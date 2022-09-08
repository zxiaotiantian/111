<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=GB2312" />
<title>MRM_CHECK_NEW_NUMBER_RANGE</title>
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
     <td><h2>Code listing for function MRM_CHECK_NEW_NUMBER_RANGE</h2>
<h3> Description: </h3></td>
   </tr>
  <tr>
     <td>
     <table class="innerTable">
       <tr>
          <td>
   <div class="code">
FUNCTION mrm_check_new_number_range.<br />
   </div>
   <div class="codeComment">
*"----------------------------------------------------------------------<br />
*"*"Lokale Schnittstelle:<br />
*"  IMPORTING<br />
*"     REFERENCE(I_RBKPV) TYPE  MRM_RBKPV<br />
*"     REFERENCE(I_BUFFER_ON) LIKE  BOOLE-BOOLE DEFAULT X<br />
*"  EXPORTING<br />
*"     VALUE(E_NEW_NUMBER) TYPE  BOOLE-BOOLE<br />
*"     VALUE(E_GJAHR) TYPE  GJAHR<br />
*"     VALUE(E_BLART_OLD) TYPE  BLART<br />
*"----------------------------------------------------------------------<br />
<br />

<div class="codeComment">*       <a href ="global-mrm_check_new_number_range.html">Global data declarations</a></div><br />
   </div>
   <div class="code">
&nbsp;&nbsp;DATA:&nbsp;s003_old&nbsp;LIKE&nbsp;t003,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;s003_new&nbsp;LIKE&nbsp;t003,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;s_rbkpv_old&nbsp;TYPE&nbsp;mrm_rbkpv.<br />
<br />
&nbsp;&nbsp;CALL&nbsp;FUNCTION&nbsp;'FI_PERIOD_DETERMINE'<br />
&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_bukrs&nbsp;=&nbsp;i_rbkpv-bukrs<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_budat&nbsp;=&nbsp;i_rbkpv-budat<br />
&nbsp;&nbsp;&nbsp;&nbsp;IMPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;e_gjahr&nbsp;=&nbsp;e_gjahr.<br />
<br />
&nbsp;&nbsp;IF&nbsp;e_gjahr&nbsp;NE&nbsp;i_rbkpv-gjahr.<br />
&nbsp;&nbsp;&nbsp;&nbsp;e_new_number&nbsp;=&nbsp;'X'.<br />
&nbsp;&nbsp;ENDIF.<br />
<br />
&nbsp;&nbsp;CALL&nbsp;FUNCTION&nbsp;'MRM_INVOICE_READ'<br />
&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_belnr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;i_rbkpv-belnr<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_gjahr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;i_rbkpv-gjahr<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_xselk&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;'X'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_buffer_on&nbsp;=&nbsp;i_buffer_on<br />
&nbsp;&nbsp;&nbsp;&nbsp;IMPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;e_rbkpv&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;s_rbkpv_old.<br />
<br />
&nbsp;&nbsp;e_blart_old&nbsp;=&nbsp;s_rbkpv_old-blart.<br />
<br />
&nbsp;&nbsp;IF&nbsp;i_rbkpv-blart&nbsp;NE&nbsp;s_rbkpv_old-blart.<br />
<br />
   </div>
   <div class="codeComment">
*--- Nummerkreise lesen<br />
<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;CALL&nbsp;FUNCTION&nbsp;'FI_DOCUMENT_TYPE_DATA'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_blart&nbsp;=&nbsp;s_rbkpv_old-blart<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;IMPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;e_t003&nbsp;&nbsp;=&nbsp;s003_old.<br />
<br />
&nbsp;&nbsp;&nbsp;&nbsp;CALL&nbsp;FUNCTION&nbsp;'FI_DOCUMENT_TYPE_DATA'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_blart&nbsp;=&nbsp;i_rbkpv-blart<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;IMPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;e_t003&nbsp;&nbsp;=&nbsp;s003_new.<br />
<br />
&nbsp;&nbsp;&nbsp;&nbsp;IF&nbsp;s003_new-numkr&nbsp;NE&nbsp;s003_old-numkr.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;e_new_number&nbsp;=&nbsp;'X'.<br />
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
