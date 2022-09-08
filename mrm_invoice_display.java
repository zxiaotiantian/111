<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=GB2312" />
<title>MRM_INVOICE_DISPLAY</title>
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
     <td><h2>Code listing for function MRM_INVOICE_DISPLAY</h2>
<h3> Description: </h3></td>
   </tr>
  <tr>
     <td>
     <table class="innerTable">
       <tr>
          <td>
   <div class="code">
FUNCTION mrm_invoice_display.<br />
   </div>
   <div class="codeComment">
*"----------------------------------------------------------------------<br />
*"*"Lokale Schnittstelle:<br />
*"  IMPORTING<br />
*"     REFERENCE(I_BELNR) TYPE  RE_BELNR<br />
*"     REFERENCE(I_GJAHR) TYPE  GJAHR OPTIONAL<br />
*"     REFERENCE(I_DISPLAY_ONLY) TYPE  XFELD OPTIONAL<br />
*"     REFERENCE(I_EDIT) TYPE  XFELD OPTIONAL<br />
*"  CHANGING<br />
*"     REFERENCE(RETURN) TYPE  BAPIRET2_TAB<br />
*"  EXCEPTIONS<br />
*"      NO_AUTHORITY<br />
*"      NOT_FOUND<br />
*"      INVALID_CALL<br />
*"----------------------------------------------------------------------<br />
<br />

<div class="codeComment">*       <a href ="global-mrm_invoice_display.html">Global data declarations</a></div><br />
   </div>
   <div class="code">
&nbsp;&nbsp;DATA:&nbsp;lo_mrm_iv_display&nbsp;TYPE&nbsp;REF&nbsp;TO&nbsp;lcl_mrm_invoice_display.<br />
<br />
&nbsp;&nbsp;"&nbsp;copy&nbsp;for&nbsp;using&nbsp;parameters&nbsp;in&nbsp;next&nbsp;screen<br />
&nbsp;&nbsp;rbkpv-belnr&nbsp;=&nbsp;i_belnr.<br />
&nbsp;&nbsp;rbkpv-gjahr&nbsp;=&nbsp;i_gjahr.<br />
&nbsp;&nbsp;mir4_change&nbsp;=&nbsp;i_edit.<br />
<br />
&nbsp;&nbsp;"&nbsp;get&nbsp;instance&nbsp;of&nbsp;local&nbsp;class<br />
&nbsp;&nbsp;CALL&nbsp;METHOD&nbsp;lcl_mrm_invoice_display=&gt;create(<br />
&nbsp;&nbsp;&nbsp;&nbsp;RECEIVING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ro_invoice_display&nbsp;=&nbsp;lo_mrm_iv_display&nbsp;).<br />
<br />
&nbsp;&nbsp;"&nbsp;use&nbsp;method&nbsp;to&nbsp;check&nbsp;document&nbsp;and&nbsp;authority<br />
&nbsp;&nbsp;lo_mrm_iv_display-&gt;check_invoice(<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CHANGING&nbsp;ct_return&nbsp;=&nbsp;return&nbsp;).<br />
<br />
&nbsp;&nbsp;IF&nbsp;return&nbsp;IS&nbsp;INITIAL.<br />
&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;not&nbsp;editable&nbsp;when&nbsp;i_display_only&nbsp;is&nbsp;TRUE<br />
&nbsp;&nbsp;&nbsp;&nbsp;f_nochange&nbsp;=&nbsp;i_display_only.<br />
<br />
&nbsp;&nbsp;&nbsp;&nbsp;CALL&nbsp;SCREEN&nbsp;6000.<br />
&nbsp;&nbsp;ELSE.<br />
&nbsp;&nbsp;&nbsp;&nbsp;RETURN.<br />
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
