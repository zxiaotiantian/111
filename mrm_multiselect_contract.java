<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=GB2312" />
<title>MRM_MULTISELECT_CONTRACT</title>
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
     <td><h2>Code listing for function MRM_MULTISELECT_CONTRACT</h2>
<h3> Description: </h3></td>
   </tr>
  <tr>
     <td>
     <table class="innerTable">
       <tr>
          <td>
   <div class="code">
FUNCTION mrm_multiselect_contract.                                       " Contracts EhP5<br />
   </div>
   <div class="codeComment">
*"----------------------------------------------------------------------<br />
*"*"Lokale Schnittstelle:<br />
*"  TABLES<br />
*"      T_ERRPROT TYPE  MRM_TAB_ERRPROT<br />
*"  CHANGING<br />
*"     REFERENCE(CT_CONTRACT) TYPE  MRM_TAB_SELECT_CONTRACT<br />
*"----------------------------------------------------------------------<br />

<div class="codeComment">*       <a href ="global-mrm_multiselect_contract.html">Global data declarations</a></div><br />
   </div>
   <div class="code">
&nbsp;&nbsp;DATA:&nbsp;lt_sel_contract&nbsp;TYPE&nbsp;mrm_tab_select_contract.<br />
&nbsp;&nbsp;FIELD-SYMBOLS:&nbsp;&lt;ls_sel_contract&gt;&nbsp;TYPE&nbsp;mrm_select_contract.<br />
<br />
&nbsp;&nbsp;LOOP&nbsp;AT&nbsp;ct_contract&nbsp;ASSIGNING&nbsp;&lt;ls_sel_contract&gt;<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;WHERE&nbsp;ebeln&nbsp;NE&nbsp;0&nbsp;AND&nbsp;ebelp&nbsp;NE&nbsp;0&nbsp;AND&nbsp;txz01&nbsp;EQ&nbsp;space.<br />
&nbsp;&nbsp;&nbsp;&nbsp;SELECT&nbsp;SINGLE&nbsp;txz01&nbsp;FROM&nbsp;ekpo&nbsp;INTO&nbsp;&lt;ls_sel_contract&gt;-txz01<br />
&nbsp;&nbsp;&nbsp;&nbsp;WHERE&nbsp;ebeln&nbsp;=&nbsp;&lt;ls_sel_contract&gt;-ebeln&nbsp;AND&nbsp;ebelp&nbsp;=&nbsp;&lt;ls_sel_contract&gt;-ebelp.<br />
&nbsp;&nbsp;ENDLOOP.<br />
&nbsp;&nbsp;lcl_mrm_contract_ui=&gt;set_contracts_data(<br />
&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;it_sel_contract&nbsp;=&nbsp;ct_contract<br />
&nbsp;&nbsp;).<br />
<br />
&nbsp;&nbsp;lcl_mrm_contract_ui=&gt;con_check_7250(<br />
&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;iv_new_entry&nbsp;=&nbsp;abap_true<br />
&nbsp;&nbsp;&nbsp;&nbsp;iv_no_message&nbsp;=&nbsp;abap_true<br />
&nbsp;&nbsp;CHANGING<br />
&nbsp;&nbsp;&nbsp;&nbsp;ct_errprot&nbsp;=&nbsp;t_errprot[]&nbsp;).<br />
<br />
&nbsp;&nbsp;CALL&nbsp;SCREEN&nbsp;7250&nbsp;STARTING&nbsp;AT&nbsp;1&nbsp;3<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ENDING&nbsp;AT&nbsp;&nbsp;85&nbsp;12.<br />
<br />
&nbsp;&nbsp;lcl_mrm_contract_ui=&gt;get_contracts_data(<br />
&nbsp;&nbsp;IMPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;et_sel_contract&nbsp;=&nbsp;ct_contract<br />
&nbsp;&nbsp;).<br />
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
