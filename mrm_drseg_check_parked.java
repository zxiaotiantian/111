<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=GB2312" />
<title>MRM_DRSEG_CHECK_PARKED</title>
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
     <td><h2>Code listing for function MRM_DRSEG_CHECK_PARKED</h2>
<h3> Description: </h3></td>
   </tr>
  <tr>
     <td>
     <table class="innerTable">
       <tr>
          <td>
   <div class="code">
FUNCTION mrm_drseg_check_parked.<br />
   </div>
   <div class="codeComment">
*"----------------------------------------------------------------------<br />
*"*"Lokale Schnittstelle:<br />
*"  IMPORTING<br />
*"     VALUE(I_RBKPV) TYPE  MRM_RBKPV<br />
*"     VALUE(I_DRSEG) TYPE  MMCR_DRSEG<br />
*"  EXPORTING<br />
*"     VALUE(E_DRSEG) TYPE  MMCR_DRSEG<br />
*"----------------------------------------------------------------------<br />
<br />
<br />

<div class="codeComment">*       <a href ="global-mrm_drseg_check_parked.html">Global data declarations</a></div><br />
   </div>
   <div class="code">
&nbsp;&nbsp;DATA&nbsp;:&nbsp;tab_msgprot&nbsp;&nbsp;TYPE&nbsp;mrm_tab_errprot.<br />
<br />
&nbsp;&nbsp;IF&nbsp;&nbsp;cl_ops_switch_check=&gt;mm_sfws_tm(&nbsp;)&nbsp;=&nbsp;abap_true&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"TM&nbsp;EhP5e<br />
&nbsp;&nbsp;AND&nbsp;rbkpv-xtm&nbsp;=&nbsp;abap_true.<br />
   </div>
   <div class="codeComment">
* No quantity checks required for TM invoices<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;e_drseg&nbsp;=&nbsp;i_drseg.<br />
&nbsp;&nbsp;&nbsp;&nbsp;RETURN.<br />
&nbsp;&nbsp;ENDIF.<br />
<br />
&nbsp;&nbsp;MOVE-CORRESPONDING:&nbsp;i_rbkpv&nbsp;TO&nbsp;mrm_qack,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_drseg&nbsp;TO&nbsp;mrm_qack.<br />
<br />
&nbsp;&nbsp;CALL&nbsp;FUNCTION&nbsp;'MRM_QUANTITY_CHECK'<br />
&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_mrm_qack&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;mrm_qack<br />
&nbsp;&nbsp;&nbsp;&nbsp;IMPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;e_spgrm&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;i_drseg-spgrm<br />
&nbsp;&nbsp;&nbsp;&nbsp;EXCEPTIONS<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;quantity_high&nbsp;=&nbsp;8<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;error_message&nbsp;=&nbsp;1.<br />
<br />
&nbsp;&nbsp;IF&nbsp;sy-subrc&nbsp;=&nbsp;8.<br />
&nbsp;&nbsp;&nbsp;&nbsp;i_drseg-spgrm&nbsp;=&nbsp;'X'.<br />
&nbsp;&nbsp;ENDIF.<br />
<br />
<br />
&nbsp;&nbsp;MOVE-CORRESPONDING:&nbsp;i_rbkpv&nbsp;TO&nbsp;mrm_opck,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_drseg&nbsp;TO&nbsp;mrm_opck.<br />
<br />
&nbsp;&nbsp;CALL&nbsp;FUNCTION&nbsp;'MRM_ORDER_PRICE_QUANTITY_CHECK'<br />
&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_mrm_opck&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;mrm_opck<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_bpmng_request&nbsp;=&nbsp;'X'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_menge_request&nbsp;=&nbsp;'X'<br />
&nbsp;&nbsp;&nbsp;&nbsp;IMPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;e_bpmng&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;i_drseg-bpmng<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;e_spgrg&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;i_drseg-spgrg<br />
&nbsp;&nbsp;&nbsp;&nbsp;EXCEPTIONS<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;error_message&nbsp;&nbsp;&nbsp;=&nbsp;1.<br />
<br />
<br />
&nbsp;&nbsp;MOVE-CORRESPONDING:&nbsp;i_rbkpv&nbsp;TO&nbsp;mrm_amck,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_drseg&nbsp;TO&nbsp;mrm_amck.<br />
<br />
&nbsp;&nbsp;IF&nbsp;cl_ops_switch_check=&gt;mm_sfws_ci_3(&nbsp;)&nbsp;=&nbsp;abap_true&nbsp;AND&nbsp;"Contract&nbsp;EhP5<br />
   </div>
   <div class="codeComment">
* Check if invoice item has a reference to a contract<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;cl_mrm_general_services=&gt;has_contract_reference(<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;iv_account_type&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;i_drseg-koart<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;iv_erp_contract_id&nbsp;=&nbsp;i_drseg-erp_contract_id&nbsp;)&nbsp;=&nbsp;abap_true.<br />
   </div>
   <div class="codeComment">
* Check if invoice item is relevant for a price check<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;IF&nbsp;lcl_mrm_contract_check=&gt;is_price_check_needed(<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;is_invoice_item&nbsp;=&nbsp;i_drseg&nbsp;)&nbsp;=&nbsp;abap_true.<br />
   </div>
   <div class="codeComment">
* Indicate that invoice item refers to a contract<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mrm_amck-xcontract&nbsp;=&nbsp;'X'.<br />
<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CALL&nbsp;FUNCTION&nbsp;'MRM_AMOUNT_CHECK'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_mrm_amck&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;mrm_amck<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;IMPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;e_spgrp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;i_drseg-spgrp<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;e_wrbtr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;i_drseg-wrbtr<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TABLES<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t_errprot&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;tab_msgprot<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXCEPTIONS<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;amount_high_warning&nbsp;=&nbsp;3<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;amount_low_warning&nbsp;&nbsp;=&nbsp;4<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;error_message&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;1.<br />
<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;IF&nbsp;sy-subrc&nbsp;=&nbsp;3.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;AMOUNT_HIGH_WARNING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;IF&nbsp;i_drseg-retpo&nbsp;IS&nbsp;INITIAL.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_drseg-spgrp&nbsp;=&nbsp;'X'.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ENDIF.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ELSEIF&nbsp;sy-subrc&nbsp;=&nbsp;4.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;AMOUNT_LOW_WARNING.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CLEAR&nbsp;i_drseg-spgrp.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ENDIF.<br />
&nbsp;&nbsp;&nbsp;&nbsp;ENDIF.<br />
&nbsp;&nbsp;ELSE.<br />
&nbsp;&nbsp;&nbsp;&nbsp;CALL&nbsp;FUNCTION&nbsp;'MRM_AMOUNT_CHECK'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_mrm_amck&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;mrm_amck<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;IMPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;e_spgrp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;i_drseg-spgrp<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;e_wrbtr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;i_drseg-wrbtr<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TABLES<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t_errprot&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;tab_msgprot<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXCEPTIONS<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;amount_high_warning&nbsp;=&nbsp;3<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;amount_low_warning&nbsp;&nbsp;=&nbsp;4<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;error_message&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;1.<br />
<br />
&nbsp;&nbsp;&nbsp;&nbsp;IF&nbsp;sy-subrc&nbsp;=&nbsp;3.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;AMOUNT_HIGH_WARNING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;IF&nbsp;i_drseg-retpo&nbsp;IS&nbsp;INITIAL.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_drseg-spgrp&nbsp;=&nbsp;'X'.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ENDIF.<br />
&nbsp;&nbsp;&nbsp;&nbsp;ELSEIF&nbsp;sy-subrc&nbsp;=&nbsp;4.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;AMOUNT_LOW_WARNING.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CLEAR&nbsp;i_drseg-spgrp.<br />
&nbsp;&nbsp;&nbsp;&nbsp;ENDIF.<br />
&nbsp;&nbsp;ENDIF.<br />
<br />
&nbsp;&nbsp;e_drseg&nbsp;=&nbsp;i_drseg.<br />
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
