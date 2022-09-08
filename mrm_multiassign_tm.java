<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=GB2312" />
<title>MRM_MULTIASSIGN_TM</title>
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
     <td><h2>Code listing for function MRM_MULTIASSIGN_TM</h2>
<h3> Description: </h3></td>
   </tr>
  <tr>
     <td>
     <table class="innerTable">
       <tr>
          <td>
   <div class="code">
FUNCTION mrm_multiassign_tm.<br />
   </div>
   <div class="codeComment">
*"----------------------------------------------------------------------<br />
*"*"Lokale Schnittstelle:<br />
*"  CHANGING<br />
*"     REFERENCE(CT_XMSEL_TM) TYPE  RBSELTM_TAB<br />
*"     REFERENCE(CT_ERRPROT) TYPE  MRM_TAB_ERRPROT OPTIONAL<br />
*"----------------------------------------------------------------------<br />

<div class="codeComment">*       <a href ="global-mrm_multiassign_tm.html">Global data declarations</a></div><br />
   </div>
   <div class="code">
&nbsp;&nbsp;DATA:&nbsp;lt_grid_tab&nbsp;TYPE&nbsp;mrm_multiassign_tm_tab,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ls_grid_tab&nbsp;TYPE&nbsp;mrm_multiassign_tm,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;lv_line&nbsp;TYPE&nbsp;i,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;lv_anzahl&nbsp;TYPE&nbsp;i.<br />
<br />
&nbsp;&nbsp;FIELD-SYMBOLS:&nbsp;&lt;ls_xmsel_tm&gt;&nbsp;TYPE&nbsp;rbseltm.<br />
<br />
   </div>
   <div class="codeComment">
* build the output table for the Multiassign. Screen 7270.<br />
<br />
   </div>
   <div class="code">
&nbsp;&nbsp;IF&nbsp;gt_xmsel_tm&nbsp;IS&nbsp;NOT&nbsp;INITIAL.<br />
&nbsp;&nbsp;&nbsp;&nbsp;LOOP&nbsp;AT&nbsp;gt_xmsel_tm&nbsp;ASSIGNING&nbsp;&lt;ls_xmsel_tm&gt;.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ls_grid_tab-to_id&nbsp;=&nbsp;&lt;ls_xmsel_tm&gt;-tmref_id.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;COLLECT&nbsp;ls_grid_tab&nbsp;INTO&nbsp;lt_grid_tab.<br />
&nbsp;&nbsp;&nbsp;&nbsp;ENDLOOP.<br />
&nbsp;&nbsp;ENDIF.<br />
<br />
&nbsp;&nbsp;lv_anzahl&nbsp;=&nbsp;-15.<br />
&nbsp;&nbsp;WHILE&nbsp;lv_anzahl&nbsp;&lt;&nbsp;0.<br />
&nbsp;&nbsp;&nbsp;&nbsp;APPEND&nbsp;INITIAL&nbsp;LINE&nbsp;TO&nbsp;lt_grid_tab.<br />
&nbsp;&nbsp;&nbsp;&nbsp;lv_anzahl&nbsp;=&nbsp;lv_anzahl&nbsp;+&nbsp;1.<br />
&nbsp;&nbsp;ENDWHILE.<br />
<br />
&nbsp;&nbsp;CALL&nbsp;METHOD&nbsp;cl_mrm_tm_services=&gt;set_mt_rbseltm<br />
&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;it_rbseltm&nbsp;=&nbsp;gt_xmsel_tm.<br />
<br />
&nbsp;&nbsp;lcl_mrm_tm_services_ui=&gt;mt_outtab&nbsp;=&nbsp;lt_grid_tab.<br />
<br />
   </div>
   <div class="codeComment">
* call screen 7270.<br />
   </div>
   <div class="code">
&nbsp;&nbsp;CALL&nbsp;SCREEN&nbsp;7270&nbsp;STARTING&nbsp;AT&nbsp;1&nbsp;1.<br />
<br />
&nbsp;&nbsp;cl_mrm_tm_services=&gt;get_mt_rbseltm(<br />
&nbsp;&nbsp;IMPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;et_rbseltm&nbsp;=&nbsp;ct_xmsel_tm&nbsp;).<br />
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
