<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=GB2312" />
<title>MRM_INFO_MESSAGE</title>
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
     <td><h2>Code listing for function MRM_INFO_MESSAGE</h2>
<h3> Description: </h3></td>
   </tr>
  <tr>
     <td>
     <table class="innerTable">
       <tr>
          <td>
   <div class="code">
FUNCTION MRM_INFO_MESSAGE.<br />
   </div>
   <div class="codeComment">
*"----------------------------------------------------------------------<br />
*"*"Lokale Schnittstelle:<br />
*"  IMPORTING<br />
*"     REFERENCE(I_MSGTY) TYPE  SYST-MSGTY<br />
*"     REFERENCE(I_MSGID) TYPE  SYST-MSGID<br />
*"     REFERENCE(I_MSGNO) TYPE  SYST-MSGNO<br />
*"     REFERENCE(I_MSGV1) TYPE  SYST-MSGV1 OPTIONAL<br />
*"     REFERENCE(I_MSGV2) TYPE  SYST-MSGV2 OPTIONAL<br />
*"     REFERENCE(I_MSGV3) TYPE  SYST-MSGV3 OPTIONAL<br />
*"     REFERENCE(I_MSGV4) TYPE  SYST-MSGV4 OPTIONAL<br />
*"----------------------------------------------------------------------<br />
* Call subscreen for info messages in PBO                  "retention<br />

<div class="codeComment">*       <a href ="global-mrm_info_message.html">Global data declarations</a></div><br />
   </div>
   <div class="code">
&nbsp;&nbsp;data:&nbsp;l_ucomm&nbsp;like&nbsp;sy-ucomm,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;l_curow&nbsp;like&nbsp;sy-curow,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;l_cucol&nbsp;like&nbsp;sy-cucol,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;l_datar&nbsp;like&nbsp;sy-datar,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;l_msgtxt(300).<br />
<br />
   </div>
   <div class="codeComment">
* Function module can handle currently only info messages<br />
   </div>
   <div class="code">
&nbsp;&nbsp;if&nbsp;i_msgty&nbsp;&lt;&gt;&nbsp;c_msgty_info.<br />
&nbsp;&nbsp;&nbsp;&nbsp;return.<br />
&nbsp;&nbsp;endif.<br />
<br />
&nbsp;&nbsp;move&nbsp;sy-ucomm&nbsp;to&nbsp;l_ucomm.<br />
&nbsp;&nbsp;move&nbsp;sy-curow&nbsp;to&nbsp;l_curow.<br />
&nbsp;&nbsp;move&nbsp;sy-cucol&nbsp;to&nbsp;l_cucol.<br />
&nbsp;&nbsp;move&nbsp;sy-datar&nbsp;to&nbsp;l_datar.<br />
<br />
&nbsp;&nbsp;message&nbsp;id&nbsp;i_msgid&nbsp;type&nbsp;i_msgty&nbsp;number&nbsp;i_msgno<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;with&nbsp;i_msgv1&nbsp;i_msgv2&nbsp;i_msgv3&nbsp;i_msgv4<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;into&nbsp;l_msgtxt.<br />
<br />
&nbsp;&nbsp;help_info-call&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;'D'.<br />
&nbsp;&nbsp;help_info-spras&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;sy-langu.<br />
&nbsp;&nbsp;help_info-object&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;'N'.<br />
&nbsp;&nbsp;help_info-docuid&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;'NA'.<br />
   </div>
   <div class="codeComment">
* help_info-dynpro     = messdynnr.<br />
   </div>
   <div class="code">
&nbsp;&nbsp;help_info-message&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;l_msgtxt.<br />
&nbsp;&nbsp;help_info-messageid&nbsp;&nbsp;=&nbsp;i_msgid.<br />
&nbsp;&nbsp;help_info-messagenr&nbsp;&nbsp;=&nbsp;i_msgno.<br />
&nbsp;&nbsp;help_info-msgv1&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;i_msgv1.<br />
&nbsp;&nbsp;help_info-msgv2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;i_msgv2.<br />
&nbsp;&nbsp;help_info-msgv3&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;i_msgv3.<br />
&nbsp;&nbsp;help_info-msgv4&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;i_msgv4.<br />
&nbsp;&nbsp;help_info-pfkey&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;'INFO'.<br />
   </div>
   <div class="codeComment">
* help_info-program    = messprogr.<br />
   </div>
   <div class="code">
&nbsp;&nbsp;help_info-title&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;'Information'(inf).&nbsp;"#EC&nbsp;TEXT_POOL<br />
<br />
   </div>
   <div class="codeComment">
* Submit popup with info message<br />
   </div>
   <div class="code">
&nbsp;&nbsp;call&nbsp;screen&nbsp;6700&nbsp;starting&nbsp;at&nbsp;11&nbsp;14.<br />
<br />
&nbsp;&nbsp;move&nbsp;l_ucomm&nbsp;to&nbsp;sy-ucomm.<br />
&nbsp;&nbsp;move&nbsp;l_curow&nbsp;to&nbsp;sy-curow.<br />
&nbsp;&nbsp;move&nbsp;l_cucol&nbsp;to&nbsp;sy-cucol.<br />
&nbsp;&nbsp;move&nbsp;l_datar&nbsp;to&nbsp;sy-datar.<br />
<br />
<br />
<br />
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
