<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=GB2312" />
<title>MRM_AC_DOC_SENDER_RMRP_RFC</title>
<style type="text/css">
.code{ font-family:"Courier New", Courier, monospace; color:#000; font-size:14px; background-color:#F2F4F7 }
  .codeComment {font-family:"Courier New", Courier, monospace; color:#0000F0; font-size:14px; background-color:#F2F4F7 }
  .normalBold{ font-family:Arial, Helvetica, sans-serif; color:#000; font-size:12px; font-weight:800 }
  .normalBoldLarge{ font-family:Arial, Helvetica, sans-serif; color:#000; font-size:16px; font-weight:800 }
</style>
<style type="text/css">
  .normal{ font-family:Arial, Helvetica, sans-serif; color:#000; font-size:12px }
  .footer{ font-family:Arial, Helvetica, sans-serif; color:#000; font-size:12px; text-align: center }
  h2{ font-family:Arial, Helvetica, sans-serif; color:#000; font-size:16px; font-weight:800 }
  h3{ font-family:Arial, Helvetica, sans-serif; color:#000; font-size:14px; font-weight:800 }
  .outerTable{
   background-color:#E0E7ED;
   width:100%;
   border-top-width: thin;
   border-right-width: thin;
   border-right-width: thin;
   border-left-width: thin;
   border-top-style: solid;
   border-right-style: solid;
   border-bottom-style: solid;
   border-left-style: solid;
  }
  .innerTable{
   background-color:#F2F4F7;
   width:100%;
   border-top-width: thin;
   border-right-width: thin;
   border-bottom-width: thin;
   border-left-width: thin;
   border-top-style: solid;
   border-right-style: solid;
   border-bottom-style: solid;
   border-left-style: solid;
  }
</style>
</head>
<body>
<table class="outerTable">
  <tr class="normalBoldLarge">
     <td><h2>Code listing for function MRM_AC_DOC_SENDER_RMRP_RFC</h2>
<h3> Description: </h3></td>
   </tr>
  <tr>
     <td>
     <table class="innerTable">
       <tr>
          <td>
   <div class="code">
FUNCTION MRM_AC_DOC_SENDER_RMRP_RFC.<br />
   </div>
   <div class="codeComment">
*"----------------------------------------------------------------------<br />
*"*"Lokale Schnittstelle:<br />
*"  IMPORTING<br />
*"     VALUE(I_AWTYP) TYPE  ACCHD-AWTYP<br />
*"     VALUE(I_AWREF) TYPE  ACCHD-AWREF<br />
*"     VALUE(I_AWORG) TYPE  ACCHD-AWORG DEFAULT SPACE<br />
*"     VALUE(I_AWSYS) TYPE  ACCHD-AWSYS DEFAULT SPACE<br />
*"     VALUE(I_BUKRS) TYPE  ACCIT-BUKRS DEFAULT SPACE<br />
*"  EXCEPTIONS<br />
*"      NO_ENTRY_FOUND<br />
*"      ARCHIVE_READ_ERROR<br />
*"----------------------------------------------------------------------<br />
<br />
** This function module was created for note 1093854<br />
* as MRM_AC_DOCUMENT_SENDER_RMRP is not RFC capable<br />
<br />

<div class="codeComment">*       <a href ="global-mrm_ac_doc_sender_rmrp_rfc.html">Global data declarations</a></div><br />
   </div>
   <div class="code">
&nbsp;&nbsp;DATA:&nbsp;lv_wrxshow_not_allowed&nbsp;&nbsp;TYPE&nbsp;abap_bool,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;lv_not_in_archive&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;abap_bool,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;lv_error&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;abap_bool,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;lo_archive&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;REF&nbsp;TO&nbsp;lcl_mrm_archive.<br />
<br />
&nbsp;&nbsp;CLEAR:&nbsp;rbkpv.<br />
<br />
&nbsp;&nbsp;MOVE:&nbsp;i_awref&nbsp;TO&nbsp;rbkpv-belnr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_aworg&nbsp;TO&nbsp;rbkpv-gjahr.<br />
<br />
&nbsp;&nbsp;SELECT&nbsp;SINGLE&nbsp;*&nbsp;FROM&nbsp;rbkp&nbsp;INTO&nbsp;CORRESPONDING&nbsp;FIELDS&nbsp;OF&nbsp;rbkpv<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;WHERE&nbsp;belnr&nbsp;=&nbsp;rbkpv-belnr<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;AND&nbsp;gjahr&nbsp;=&nbsp;rbkpv-gjahr.<br />
<br />
   </div>
   <div class="codeComment">
* If invoice doc is not found in DB try to find invoice in archive<br />
   </div>
   <div class="code">
&nbsp;&nbsp;IF&nbsp;sy-subrc&nbsp;&lt;&gt;&nbsp;0.<br />
&nbsp;&nbsp;&nbsp;&nbsp;CREATE&nbsp;OBJECT&nbsp;lo_archive.<br />
&nbsp;&nbsp;&nbsp;&nbsp;CALL&nbsp;METHOD&nbsp;lo_archive-&gt;invoice_load<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;iv_belnr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;rbkpv-belnr<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;iv_gjahr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;rbkpv-gjahr<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;IMPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ev_not_in_archive&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;lv_not_in_archive<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ev_wrxshow_not_allowed&nbsp;=&nbsp;lv_wrxshow_not_allowed<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ev_error&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;lv_error<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CHANGING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;cs_rbkpv&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;rbkpv<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ct_xrseg&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;xrseg[]<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ct_xrbco&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;xrbco[]<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ct_xrbma&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;xrbma[]<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ct_xivext&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;xivext[].<br />
<br />
&nbsp;&nbsp;&nbsp;&nbsp;FREE&nbsp;lo_archive.<br />
<br />
   </div>
   <div class="codeComment">
*   an error occured<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;IF&nbsp;lv_error&nbsp;=&nbsp;abap_true.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MESSAGE&nbsp;ID&nbsp;sy-msgid&nbsp;TYPE&nbsp;'I'&nbsp;NUMBER&nbsp;sy-msgno<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;WITH&nbsp;sy-msgv1&nbsp;sy-msgv2&nbsp;sy-msgv3&nbsp;sy-msgv4<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;RAISING&nbsp;archive_read_error.<br />
   </div>
   <div class="codeComment">
*   requested document is not in archiving system<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;ELSEIF&nbsp;lv_not_in_archive&nbsp;=&nbsp;abap_true.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;RAISE&nbsp;no_entry_found.<br />
&nbsp;&nbsp;&nbsp;&nbsp;ENDIF.<br />
&nbsp;&nbsp;ENDIF.<br />
<br />
&nbsp;&nbsp;IF&nbsp;lv_error&nbsp;IS&nbsp;INITIAL&nbsp;AND&nbsp;lv_not_in_archive&nbsp;IS&nbsp;INITIAL.<br />
&nbsp;&nbsp;&nbsp;&nbsp;IF&nbsp;rbkpv-ivtyp&nbsp;&lt;&gt;&nbsp;c_ivtyp_maint&nbsp;AND<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rbkpv-ivtyp&nbsp;&lt;&gt;&nbsp;c_ivtyp_bapi_maint.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SET&nbsp;PARAMETER&nbsp;ID&nbsp;'RBN'&nbsp;FIELD&nbsp;rbkpv-belnr.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SET&nbsp;PARAMETER&nbsp;ID&nbsp;'GJR'&nbsp;FIELD&nbsp;rbkpv-gjahr.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CALL&nbsp;TRANSACTION&nbsp;tcode_mir4&nbsp;AND&nbsp;SKIP&nbsp;FIRST&nbsp;SCREEN.<br />
&nbsp;&nbsp;&nbsp;&nbsp;ELSE.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SET&nbsp;PARAMETER&nbsp;ID&nbsp;'KBN'&nbsp;FIELD&nbsp;rbkpv-belnr.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SET&nbsp;PARAMETER&nbsp;ID&nbsp;'GJR'&nbsp;FIELD&nbsp;rbkpv-gjahr.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CALL&nbsp;TRANSACTION&nbsp;tcode_kpsh&nbsp;AND&nbsp;SKIP&nbsp;FIRST&nbsp;SCREEN.<br />
&nbsp;&nbsp;&nbsp;&nbsp;ENDIF.<br />
&nbsp;&nbsp;ENDIF.<br />
<br />
ENDFUNCTION.<br />
            </div>
          </td>
        </tr>
      </table>
      </td>
      </tr>
   <tr>
<td class="footer">Extracted by Mass Download version 1.4.1 - E.G.Mellodew. 1998-2022. Sap Release 731</td>
   </tr>
</table>
</body>
</html>
