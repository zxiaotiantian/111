<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=GB2312" />
<title>MRM_ARCHIVE_INVOICE_DISPLAY</title>
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
     <td><h2>Code listing for function MRM_ARCHIVE_INVOICE_DISPLAY</h2>
<h3> Description: </h3></td>
   </tr>
  <tr>
     <td>
     <table class="innerTable">
       <tr>
          <td>
   <div class="code">
FUNCTION mrm_archive_invoice_display.<br />
   </div>
   <div class="codeComment">
*"----------------------------------------------------------------------<br />
*"*"Lokale Schnittstelle:<br />
*"  IMPORTING<br />
*"     VALUE(I_RBKP) LIKE  RBKP STRUCTURE  RBKP<br />
*"     VALUE(I_ARCHIVNAME) LIKE  ADMI_FILES-ARCHIV_KEY<br />
*"     VALUE(I_TAX_AUDITOR) TYPE  C OPTIONAL<br />
*"  TABLES<br />
*"      T_RSEG STRUCTURE  RSEG<br />
*"      T_RBCO STRUCTURE  RBCO<br />
*"      T_RBTX STRUCTURE  RBTX<br />
*"      T_RBVS STRUCTURE  RBVS<br />
*"      T_RBWS STRUCTURE  RBWS<br />
*"      T_KONV STRUCTURE  KONV<br />
*"      T_RBMA STRUCTURE  RBMA<br />
*"      T_IVEXT STRUCTURE  IVEXT OPTIONAL<br />
*"      T_RBDPC STRUCTURE  RBDPC OPTIONAL<br />
*"      T_RSEG_TM STRUCTURE  RSEG_TM OPTIONAL<br />
*"----------------------------------------------------------------------<br />
<br />
<br />

<div class="codeComment">*       <a href ="global-mrm_archive_invoice_display.html">Global data declarations</a></div><br />
   </div>
   <div class="code">
&nbsp;&nbsp;DATA:&nbsp;s_rbvs&nbsp;&nbsp;LIKE&nbsp;rbvs,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;s_rbvs2&nbsp;TYPE&nbsp;mrm_rbvs.<br />
<br />
   </div>
   <div class="codeComment">
* authorization for tax auditor<br />
   </div>
   <div class="code">
&nbsp;&nbsp;DATA:&nbsp;h_repid&nbsp;TYPE&nbsp;progname,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;s_rseg&nbsp;&nbsp;TYPE&nbsp;rseg,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h_bukrs&nbsp;LIKE&nbsp;t001-bukrs.<br />
<br />
&nbsp;&nbsp;DATA:&nbsp;BEGIN&nbsp;OF&nbsp;rbkp_objkey,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;belnr&nbsp;LIKE&nbsp;rbkp-belnr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gjahr&nbsp;LIKE&nbsp;rbkp-gjahr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;END&nbsp;OF&nbsp;rbkp_objkey.<br />
<br />
&nbsp;&nbsp;DATA:&nbsp;e_rbkp&nbsp;LIKE&nbsp;rbkp.<br />
<br />
&nbsp;&nbsp;g_archivname&nbsp;=&nbsp;i_archivname.<br />
<br />
   </div>
   <div class="codeComment">
*--- Kopf aufbauen ---------------------------------------------------*<br />
   </div>
   <div class="code">
&nbsp;&nbsp;CLEAR&nbsp;rbkpv.<br />
&nbsp;&nbsp;MOVE-CORRESPONDING&nbsp;i_rbkp&nbsp;TO&nbsp;rbkpv.<br />
<br />
   </div>
   <div class="codeComment">
*----- document still deleted -----------------------------------------*<br />
   </div>
   <div class="code">
&nbsp;&nbsp;IF&nbsp;rbkpv-rbstat&nbsp;=&nbsp;c_rbstat_delete.<br />
<br />
   </div>
   <div class="codeComment">
*----- ... special message if deleted and inserted due to new key -----*<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;IF&nbsp;rbkpv-xblnr(2)&nbsp;=&nbsp;'&&'.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MESSAGE&nbsp;i419&nbsp;WITH&nbsp;rbkpv-belnr<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rbkpv-gjahr<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rbkpv-xblnr+2(10)<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rbkpv-xblnr+12(4).<br />
&nbsp;&nbsp;&nbsp;&nbsp;ELSE.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MESSAGE&nbsp;i417&nbsp;WITH&nbsp;rbkpv-belnr.<br />
&nbsp;&nbsp;&nbsp;&nbsp;ENDIF.<br />
&nbsp;&nbsp;&nbsp;&nbsp;EXIT.<br />
&nbsp;&nbsp;ENDIF.<br />
<br />
   </div>
   <div class="codeComment">
* Steuern<br />
   </div>
   <div class="code">
&nbsp;&nbsp;IF&nbsp;rbkpv-xrbtx&nbsp;NE&nbsp;'X'.<br />
&nbsp;&nbsp;&nbsp;&nbsp;PERFORM&nbsp;rbkp_import&nbsp;USING&nbsp;i_rbkp&nbsp;&nbsp;"alle&nbsp;Steuerinfos&nbsp;in&nbsp;RBKP<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CHANGING&nbsp;rbkpv.<br />
&nbsp;&nbsp;ELSE.<br />
&nbsp;&nbsp;&nbsp;&nbsp;rbkpv-rbtx[]&nbsp;=&nbsp;t_rbtx[].&nbsp;&nbsp;&nbsp;&nbsp;"Steuerinfos&nbsp;in&nbsp;Tabelle&nbsp;RBTX<br />
&nbsp;&nbsp;ENDIF.<br />
<br />
&nbsp;&nbsp;rbkpv-h_rbws[]&nbsp;=&nbsp;t_rbws[].<br />
<br />
   </div>
   <div class="codeComment">
* RBVS erweitern um SELKZ<br />
   </div>
   <div class="code">
&nbsp;&nbsp;CLEAR&nbsp;rbkpv-h_rbvs[].<br />
&nbsp;&nbsp;LOOP&nbsp;AT&nbsp;t_rbvs&nbsp;INTO&nbsp;s_rbvs.<br />
&nbsp;&nbsp;&nbsp;&nbsp;MOVE-CORRESPONDING&nbsp;s_rbvs&nbsp;TO&nbsp;s_rbvs2.<br />
&nbsp;&nbsp;&nbsp;&nbsp;s_rbvs2-selkz&nbsp;=&nbsp;x.&nbsp;&nbsp;&nbsp;"nicht&nbsp;in&nbsp;Tabelle&nbsp;RBVS&nbsp;enthalten<br />
&nbsp;&nbsp;&nbsp;&nbsp;APPEND&nbsp;s_rbvs2&nbsp;TO&nbsp;rbkpv-h_rbvs.<br />
&nbsp;&nbsp;ENDLOOP.<br />
<br />
   </div>
   <div class="codeComment">
*--- Positionen aufbauen ----------------------------------------------*<br />
   </div>
   <div class="code">
&nbsp;&nbsp;CLEAR&nbsp;ydrseg[].<br />
&nbsp;&nbsp;xrseg[]&nbsp;=&nbsp;t_rseg[].<br />
&nbsp;&nbsp;xrbco[]&nbsp;=&nbsp;t_rbco[].<br />
&nbsp;&nbsp;xrbma[]&nbsp;=&nbsp;t_rbma[].<br />
&nbsp;&nbsp;xivext[]&nbsp;=&nbsp;t_ivext[].&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"NCF<br />
<br />
&nbsp;&nbsp;akt_typ&nbsp;=&nbsp;'A'.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;HW&nbsp;327265<br />
&nbsp;&nbsp;t169-trtyp&nbsp;=&nbsp;'A'.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;HW&nbsp;327265<br />
&nbsp;&nbsp;PERFORM&nbsp;document_ergaenzen.<br />
<br />
<br />
   </div>
   <div class="codeComment">
*---  Positionliste anzeigen ------------------------------------------*<br />
   </div>
   <div class="code">
&nbsp;&nbsp;SELECT&nbsp;SINGLE&nbsp;*&nbsp;FROM&nbsp;t066&nbsp;WHERE&nbsp;fcode&nbsp;=&nbsp;'AB'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;AND&nbsp;&nbsp;&nbsp;vorga&nbsp;=&nbsp;'RD'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;AND&nbsp;&nbsp;&nbsp;trtyp&nbsp;=&nbsp;'A'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;AND&nbsp;&nbsp;&nbsp;bevar&nbsp;=&nbsp;space<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;AND&nbsp;&nbsp;&nbsp;buvar&nbsp;=&nbsp;space.<br />
<br />
&nbsp;&nbsp;t169-vgart&nbsp;=&nbsp;'RD'.<br />
&nbsp;&nbsp;MOVE&nbsp;sy-tcode&nbsp;TO&nbsp;t169-tcode.<br />
&nbsp;&nbsp;MOVE&nbsp;'X'&nbsp;TO&nbsp;g_archive_display.<br />
&nbsp;&nbsp;CLEAR:&nbsp;init,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;init_6000,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_dbread,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ok-code.<br />
<br />
   </div>
   <div class="codeComment">
* authorization for tax auditor<br />
   </div>
   <div class="code">
&nbsp;&nbsp;IF&nbsp;i_tax_auditor&nbsp;EQ&nbsp;'1'.<br />
&nbsp;&nbsp;&nbsp;&nbsp;CLEAR&nbsp;h_bukrs.<br />
   </div>
   <div class="codeComment">
* check authorization for budat and bukrs<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;MOVE&nbsp;sy-repid&nbsp;TO&nbsp;h_repid.<br />
&nbsp;&nbsp;&nbsp;&nbsp;LOOP&nbsp;AT&nbsp;xrseg&nbsp;INTO&nbsp;s_rseg.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;IF&nbsp;s_rseg-bukrs&nbsp;EQ&nbsp;h_bukrs.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ELSE.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MOVE&nbsp;s_rseg-bukrs&nbsp;TO&nbsp;h_bukrs.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CALL&nbsp;FUNCTION&nbsp;'MRM_TAX_AUDITOR_CHECK'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_user&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;sy-uname<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_program&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;h_repid<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_budat&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;rbkpv-budat<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_bukrs&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;h_bukrs<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXCEPTIONS<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;no_authority_prog&nbsp;=&nbsp;1<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;no_authority_date&nbsp;=&nbsp;2<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OTHERS&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;3.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CASE&nbsp;&nbsp;&nbsp;sy-subrc.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;WHEN&nbsp;&nbsp;0.<br />
   </div>
   <div class="codeComment">
*         tax auditor has the authorization<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;WHEN&nbsp;&nbsp;1.<br />
   </div>
   <div class="codeComment">
*         no authorization to execute the program<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MESSAGE&nbsp;e001(ca_check_date)&nbsp;WITH&nbsp;h_repid.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;WHEN&nbsp;&nbsp;2.<br />
   </div>
   <div class="codeComment">
*         no authorization for this date<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MESSAGE&nbsp;e002(ca_check_date).<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;WHEN&nbsp;&nbsp;OTHERS.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MESSAGE&nbsp;ID&nbsp;sy-msgid&nbsp;TYPE&nbsp;sy-msgty&nbsp;NUMBER&nbsp;sy-msgno<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;WITH&nbsp;sy-msgv1&nbsp;sy-msgv2&nbsp;sy-msgv3&nbsp;sy-msgv4.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ENDCASE.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ENDIF.<br />
&nbsp;&nbsp;&nbsp;&nbsp;ENDLOOP.<br />
   </div>
   <div class="codeComment">
* write invoice document number and year in the log file<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;CALL&nbsp;FUNCTION&nbsp;'MRM_TAX_AUDITOR_CHECK'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_user&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;sy-uname<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_program&nbsp;&nbsp;&nbsp;=&nbsp;h_repid<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_write_log&nbsp;=&nbsp;'X'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_belnr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;rbkpv-belnr<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_gjahr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;rbkpv-gjahr<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_applk&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;'RE'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXCEPTIONS<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OTHERS&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;3.<br />
<br />
&nbsp;&nbsp;&nbsp;&nbsp;IF&nbsp;&nbsp;sy-subrc&nbsp;NE&nbsp;0.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MESSAGE&nbsp;ID&nbsp;sy-msgid&nbsp;TYPE&nbsp;sy-msgty&nbsp;NUMBER&nbsp;sy-msgno<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;WITH&nbsp;sy-msgv1&nbsp;sy-msgv2&nbsp;sy-msgv3&nbsp;sy-msgv4.<br />
&nbsp;&nbsp;&nbsp;&nbsp;ENDIF.<br />
&nbsp;&nbsp;ENDIF.<br />
<br />
&nbsp;&nbsp;CALL&nbsp;METHOD&nbsp;lcl_mrm_dpc_dialog=&gt;set_archive_rbdpc&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"DPC&nbsp;EhP4<br />
&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;it_rbdpc&nbsp;=&nbsp;t_rbdpc[].<br />
<br />
&nbsp;&nbsp;IF&nbsp;t_rseg_tm[]&nbsp;IS&nbsp;NOT&nbsp;INITIAL.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"Ehp5e&nbsp;TM<br />
&nbsp;&nbsp;&nbsp;&nbsp;rbkpv-xtm&nbsp;=&nbsp;abap_true.<br />
&nbsp;&nbsp;&nbsp;&nbsp;CALL&nbsp;METHOD&nbsp;cl_mrm_tm_services=&gt;set_rseg_tm<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;it_mt_rseg_tm&nbsp;=&nbsp;t_rseg_tm[].<br />
&nbsp;&nbsp;ENDIF.<br />
<br />
&nbsp;&nbsp;IF&nbsp;rbkpv-ivtyp&nbsp;&lt;&gt;&nbsp;'C'.<br />
&nbsp;&nbsp;&nbsp;&nbsp;CALL&nbsp;SCREEN&nbsp;'6000'.<br />
&nbsp;&nbsp;ELSE.<br />
&nbsp;&nbsp;&nbsp;&nbsp;MOVE-CORRESPONDING&nbsp;rbkpv&nbsp;TO&nbsp;e_rbkp.<br />
&nbsp;&nbsp;&nbsp;&nbsp;EXPORT&nbsp;e_rbkp<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;xrseg<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;xrbco<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;g_archive_display<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TO&nbsp;MEMORY&nbsp;ID&nbsp;'MRM_ARCHIVE'.<br />
&nbsp;&nbsp;&nbsp;&nbsp;CALL&nbsp;TRANSACTION&nbsp;tcode_kpsh&nbsp;AND&nbsp;SKIP&nbsp;FIRST&nbsp;SCREEN.<br />
&nbsp;&nbsp;ENDIF.<br />
<br />
   </div>
   <div class="codeComment">
*----- generic object services<br />
   </div>
   <div class="code">
&nbsp;&nbsp;MOVE-CORRESPONDING&nbsp;rbkpv&nbsp;TO&nbsp;rbkp_objkey.<br />
&nbsp;&nbsp;CALL&nbsp;FUNCTION&nbsp;'SWU_OBJECT_RESTORE'<br />
&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;objtype&nbsp;=&nbsp;c_objtyp_bus2081<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;objkey&nbsp;&nbsp;=&nbsp;rbkp_objkey.<br />
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
