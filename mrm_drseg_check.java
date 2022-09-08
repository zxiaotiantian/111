<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=GB2312" />
<title>MRM_DRSEG_CHECK</title>
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
     <td><h2>Code listing for function MRM_DRSEG_CHECK</h2>
<h3> Description: </h3></td>
   </tr>
  <tr>
     <td>
     <table class="innerTable">
       <tr>
          <td>
   <div class="code">
FUNCTION mrm_drseg_check.<br />
   </div>
   <div class="codeComment">
*"----------------------------------------------------------------------<br />
*"*"Local Interface:<br />
*"  IMPORTING<br />
*"     VALUE(I_RBKPV) TYPE  MRM_RBKPV<br />
*"     VALUE(I_DRSEG) TYPE  MMCR_DRSEG<br />
*"     REFERENCE(I_XERRORLOG) TYPE  BOOLE-BOOLE OPTIONAL<br />
*"  EXPORTING<br />
*"     VALUE(E_DRSEG) TYPE  MMCR_DRSEG<br />
*"  TABLES<br />
*"      T_MSGPROT TYPE  MRM_TAB_ERRPROT<br />
*"----------------------------------------------------------------------<br />
<br />

<div class="codeComment">*       <a href ="global-mrm_drseg_check.html">Global data declarations</a></div><br />
   </div>
   <div class="code">
&nbsp;&nbsp;DATA:&nbsp;h_kalsm&nbsp;LIKE&nbsp;t007a-kalsm,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h_kalsm_ttxd&nbsp;LIKE&nbsp;ttxd-kalsm,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;anzahl&nbsp;TYPE&nbsp;i,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;drseg_co_wa&nbsp;TYPE&nbsp;mmcr_drseg_co,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_bpmng_request&nbsp;TYPE&nbsp;C.<br />
<br />
<br />
   </div>
   <div class="codeComment">
*-------- Im EDI-Fall wird BPMNG immer aus MENGE ermittelt ----------*<br />
   </div>
   <div class="code">
&nbsp;&nbsp;IF&nbsp;(&nbsp;I_RBKPV-IVTYP&nbsp;=&nbsp;C_IVTYP_EDI&nbsp;OR&nbsp;I_RBKPV-IVTYP&nbsp;=&nbsp;C_IVTYP_TP&nbsp;OR<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;I_RBKPV-IVTYP&nbsp;=&nbsp;C_IVTYP_SOA_B2B&nbsp;)&nbsp;AND&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"SOA-B2B<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_drseg-bpmng&nbsp;IS&nbsp;INITIAL.<br />
&nbsp;&nbsp;&nbsp;CLEAR&nbsp;F_BPMNG_REQUEST.<br />
&nbsp;&nbsp;ELSE.<br />
&nbsp;&nbsp;&nbsp;F_BPMNG_REQUEST&nbsp;=&nbsp;'X'.<br />
&nbsp;&nbsp;ENDIF.<br />
<br />
<br />
   </div>
   <div class="codeComment">
*-------- Steuerschemata lesen ---------------------------------------*<br />
   </div>
   <div class="code">
&nbsp;&nbsp;CALL&nbsp;FUNCTION&nbsp;'MRM_READ_TAX_SCHEME'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_bukrs&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;i_rbkpv-bukrs<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;IMPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;e_kalsm&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;h_kalsm<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;e_kalsm_ttxd&nbsp;=&nbsp;h_kalsm_ttxd.<br />
<br />
   </div>
   <div class="codeComment">
*-------- Steuerkennzeichen prüfen -----------------------------------*<br />
   </div>
   <div class="code">
&nbsp;&nbsp;DESCRIBE&nbsp;TABLE&nbsp;i_drseg-co&nbsp;LINES&nbsp;anzahl.<br />
&nbsp;&nbsp;IF&nbsp;anzahl&nbsp;=&nbsp;0&nbsp;AND&nbsp;NOT&nbsp;i_drseg-mwskz&nbsp;IS&nbsp;INITIAL.<br />
&nbsp;&nbsp;&nbsp;&nbsp;CALL&nbsp;FUNCTION&nbsp;'TAX_INDICATOR_CHECK'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;steuerkennzeichen&nbsp;=&nbsp;i_drseg-mwskz<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;steuerschema&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;h_kalsm.<br />
<br />
&nbsp;&nbsp;&nbsp;&nbsp;IF&nbsp;NOT&nbsp;i_drseg-txjcd&nbsp;IS&nbsp;INITIAL.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CALL&nbsp;FUNCTION&nbsp;'TXJCD_CHECK'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_bukrs&nbsp;=&nbsp;i_rbkpv-bukrs<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_kalsm&nbsp;=&nbsp;h_kalsm<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_txjcd&nbsp;=&nbsp;i_drseg-txjcd.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CALL&nbsp;FUNCTION&nbsp;'TXJCD_CONTROL'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_txjcd&nbsp;=&nbsp;i_drseg-txjcd.<br />
&nbsp;&nbsp;&nbsp;&nbsp;ENDIF.<br />
&nbsp;&nbsp;ELSE.<br />
&nbsp;&nbsp;&nbsp;&nbsp;LOOP&nbsp;AT&nbsp;i_drseg-co&nbsp;INTO&nbsp;drseg_co_wa.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;IF&nbsp;NOT&nbsp;drseg_co_wa-mwskz&nbsp;IS&nbsp;INITIAL.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CALL&nbsp;FUNCTION&nbsp;'TAX_INDICATOR_CHECK'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;steuerkennzeichen&nbsp;=&nbsp;drseg_co_wa-mwskz<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;steuerschema&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;h_kalsm.<br />
<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;IF&nbsp;NOT&nbsp;drseg_co_wa-txjcd&nbsp;IS&nbsp;INITIAL.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CALL&nbsp;FUNCTION&nbsp;'TXJCD_CHECK'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_bukrs&nbsp;=&nbsp;i_rbkpv-bukrs<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_kalsm&nbsp;=&nbsp;h_kalsm<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_txjcd&nbsp;=&nbsp;drseg_co_wa-txjcd.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CALL&nbsp;FUNCTION&nbsp;'TXJCD_CONTROL'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_txjcd&nbsp;=&nbsp;drseg_co_wa-txjcd.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ENDIF.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ENDIF.<br />
&nbsp;&nbsp;&nbsp;&nbsp;ENDLOOP.<br />
&nbsp;&nbsp;ENDIF.<br />
ENHANCEMENT-SECTION     MRM_DRSEG_CHECK_02 SPOTS ES_SAPLMR1M.<br />
<br />
   </div>
   <div class="codeComment">
* Do not perform the below checks for the cancellation of a complete<br />
* reduced invoice item (invoice reduction) in order to prevent<br />
* e.g. M8 283 during the cancellation<br />
   </div>
   <div class="code">
&nbsp;&nbsp;IF&nbsp;i_rbkpv-ivtyp&nbsp;NE&nbsp;c_ivtyp_storno&nbsp;OR&nbsp;&nbsp;"no&nbsp;cancellation<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;NOT&nbsp;(&nbsp;i_drseg-menge&nbsp;IS&nbsp;INITIAL&nbsp;AND&nbsp;&nbsp;&nbsp;"quantity&nbsp;not&nbsp;initial&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"N1762216<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_drseg-bpmng&nbsp;IS&nbsp;INITIAL&nbsp;AND&nbsp;&nbsp;&nbsp;"PO&nbsp;price&nbsp;quantity&nbsp;not&nbsp;initial&nbsp;"N1762216<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_drseg-wrbtr&nbsp;IS&nbsp;INITIAL&nbsp;).&nbsp;&nbsp;&nbsp;"amount&nbsp;not&nbsp;initial<br />
   </div>
   <div class="codeComment">
*-------- Menge prüfen -----------------------------------------------*<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;PERFORM&nbsp;menge_pruefen&nbsp;USING&nbsp;&nbsp;i_rbkpv<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_xerrorlog<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CHANGING&nbsp;i_drseg.<br />
&nbsp;&nbsp;&nbsp;&nbsp;IF&nbsp;NOT&nbsp;i_xerrorlog&nbsp;IS&nbsp;INITIAL.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;PERFORM&nbsp;messages_uebernehmen.<br />
&nbsp;&nbsp;&nbsp;&nbsp;ENDIF.<br />
<br />
   </div>
   <div class="codeComment">
*-------- Bestellpreismenge prüfen -----------------------------------*<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;PERFORM&nbsp;bpmng_pruefen&nbsp;TABLES&nbsp;&nbsp;&nbsp;t_msgprot<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;USING&nbsp;&nbsp;&nbsp;&nbsp;'X'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_bpmng_request<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_rbkpv<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CHANGING&nbsp;i_drseg.<br />
<br />
   </div>
   <div class="codeComment">
*-------- Wert prüfen ------------------------------------------------*<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;PERFORM&nbsp;wert_pruefen&nbsp;TABLES&nbsp;&nbsp;&nbsp;t_msgprot<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;USING&nbsp;&nbsp;&nbsp;&nbsp;i_rbkpv<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;space<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CHANGING&nbsp;i_drseg.<br />
&nbsp;&nbsp;ENDIF.<br />
END-ENHANCEMENT-SECTION.<br />
ENHANCEMENT-POINT MRM_DRSEG_CHECK_01 SPOTS ES_SAPLMR1M.<br />
   </div>
   <div class="codeComment">
*------- Bei Storno keine Sperrgründe --------------------------------*<br />
   </div>
   <div class="code">
&nbsp;&nbsp;IF&nbsp;i_rbkpv-ivtyp&nbsp;EQ&nbsp;c_ivtyp_storno.<br />
&nbsp;&nbsp;&nbsp;&nbsp;CLEAR:&nbsp;i_drseg-spgrg,&nbsp;i_drseg-spgrm,&nbsp;i_drseg-spgrp.<br />
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
