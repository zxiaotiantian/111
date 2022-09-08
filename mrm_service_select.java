<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=GB2312" />
<title>MRM_SERVICE_SELECT</title>
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
     <td><h2>Code listing for function MRM_SERVICE_SELECT</h2>
<h3> Description: </h3></td>
   </tr>
  <tr>
     <td>
     <table class="innerTable">
       <tr>
          <td>
   <div class="code">
FUNCTION mrm_service_select.<br />
   </div>
   <div class="codeComment">
*"----------------------------------------------------------------------<br />
*"*"Lokale Schnittstelle:<br />
*"  IMPORTING<br />
*"     REFERENCE(IV_EBELN) TYPE  EBELN<br />
*"     REFERENCE(IV_EBELP) TYPE  EBELP<br />
*"     REFERENCE(IV_ACTIVITY) TYPE  CHAR1 DEFAULT SPACE<br />
*"  TABLES<br />
*"      ET_EK08RN TYPE  MMCR_XEK08RN<br />
*"----------------------------------------------------------------------<br />
* This function module is used to display the service lines of conrtact item<br />
* in hierarchy<br />
* ALV tree is used to display the lines in heirarchy.<br />

<div class="codeComment">*       <a href ="global-mrm_service_select.html">Global data declarations</a></div><br />
   </div>
   <div class="code">
&nbsp;&nbsp;DATA&nbsp;:&nbsp;lt_srv_package&nbsp;TYPE&nbsp;mmsrv_srv_pkg_tty.<br />
&nbsp;&nbsp;CLEAR&nbsp;gt_outtab.<br />
<br />
   </div>
   <div class="codeComment">
* select all the service lines from contract item<br />
   </div>
   <div class="code">
&nbsp;&nbsp;CALL&nbsp;METHOD&nbsp;lcl_mrm_contract_ui=&gt;service_selection<br />
&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;iv_ebeln&nbsp;=&nbsp;iv_ebeln<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;iv_ebelp&nbsp;=&nbsp;iv_ebelp.<br />
   </div>
   <div class="codeComment">
* For invoice flag is set as SPACE and for subsequent credit/debit  flag is set as 'X'<br />
   </div>
   <div class="code">
&nbsp;&nbsp;g_flag&nbsp;&nbsp;=&nbsp;iv_activity.<br />
   </div>
   <div class="codeComment">
* Display servce lines in hierarchy<br />
   </div>
   <div class="code">
&nbsp;&nbsp;CALL&nbsp;METHOD&nbsp;lcl_mrm_contract_ui=&gt;alv_hierarchy_display.<br />
<br />
<br />
&nbsp;&nbsp;et_ek08rn[]&nbsp;=&nbsp;gt_service_ek08rn[]&nbsp;.<br />
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
