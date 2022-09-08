<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=GB2312" />
<title>MRM_INVOICE_CHANGE</title>
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
     <td><h2>Code listing for function MRM_INVOICE_CHANGE</h2>
<h3> Description: </h3></td>
   </tr>
  <tr>
     <td>
     <table class="innerTable">
       <tr>
          <td>
   <div class="code">
FUNCTION mrm_invoice_change.<br />
   </div>
   <div class="codeComment">
*"----------------------------------------------------------------------<br />
*"*"Lokale Schnittstelle:<br />
*"  IMPORTING<br />
*"     VALUE(I_AKTTYP) LIKE  T169-TRTYP<br />
*"  CHANGING<br />
*"     VALUE(C_RBKPV) TYPE  MRM_RBKPV<br />
*"     VALUE(C_FCODE)<br />
*"----------------------------------------------------------------------<br />
<br />

<div class="codeComment">*       <a href ="global-mrm_invoice_change.html">Global data declarations</a></div><br />
   </div>
   <div class="code">
&nbsp;&nbsp;ok-code&nbsp;=&nbsp;c_fcode.<br />
&nbsp;&nbsp;h_rbkpv&nbsp;=&nbsp;c_rbkpv.<br />
&nbsp;&nbsp;rbkpv&nbsp;&nbsp;&nbsp;=&nbsp;c_rbkpv.<br />
   </div>
   <div class="codeComment">
* MOVE-CORRESPONDING c_rbkpv TO rm08m.<br />
<br />
   </div>
   <div class="code">
&nbsp;&nbsp;akt_typ&nbsp;=&nbsp;i_akttyp.<br />
<br />
   </div>
   <div class="codeComment">
* Lesen der Zuordnungskriterien<br />
   </div>
   <div class="code">
&nbsp;&nbsp;CLEAR:&nbsp;&nbsp;&nbsp;xmsel_best,&nbsp;xmsel_frbr,&nbsp;xmsel_lifs,&nbsp;xmsel_werk,&nbsp;xmsel_tran,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gt_xmsel_tmtran.<br />
&nbsp;&nbsp;REFRESH:&nbsp;xmsel_best,&nbsp;xmsel_frbr,&nbsp;xmsel_lifs,&nbsp;xmsel_werk,&nbsp;xmsel_tran,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gt_xmsel_tmtran,&nbsp;gt_xmsel_contract.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"EhP5&nbsp;Contracts<br />
<br />
&nbsp;&nbsp;CALL&nbsp;FUNCTION&nbsp;'MRM_DBTAB_RBSEL_READ'<br />
&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_belnr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;rbkpv-belnr<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_gjahr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;rbkpv-gjahr<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_xbest&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;rbkpv-xbest<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_xfrbr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;rbkpv-xfrbr<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_xlifs&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;rbkpv-xlifs<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_xwerk&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;rbkpv-xwerk<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_xerfb&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;rbkpv-xerfb<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_xtran&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;rbkpv-xtran<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_xtmtran&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;rbkpv-xtmtran<br />
&nbsp;&nbsp;&nbsp;&nbsp;IMPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t_rbselcontract&nbsp;=&nbsp;gt_xmsel_contract[]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"EhP5&nbsp;Contracts<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t_rbseltmtran&nbsp;&nbsp;&nbsp;=&nbsp;gt_xmsel_tmtran[]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"EhP5&nbsp;TM<br />
&nbsp;&nbsp;&nbsp;&nbsp;TABLES<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t_rbselbest&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;xmsel_best<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t_rbselfrbr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;xmsel_frbr<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t_rbsellifs&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;xmsel_lifs<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t_rbselwerk&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;xmsel_werk<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t_rbselerfb&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;xmsel_erfb<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t_rbseltran&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;xmsel_tran<br />
&nbsp;&nbsp;&nbsp;&nbsp;EXCEPTIONS<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OTHERS&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;0.<br />
<br />
&nbsp;&nbsp;IF&nbsp;rbkpv-xbest&nbsp;=&nbsp;'X'.<br />
&nbsp;&nbsp;&nbsp;&nbsp;READ&nbsp;TABLE&nbsp;xmsel_best&nbsp;INDEX&nbsp;1.<br />
&nbsp;&nbsp;&nbsp;&nbsp;rm08m-ebeln&nbsp;=&nbsp;xmsel_best-ebeln.<br />
&nbsp;&nbsp;&nbsp;&nbsp;rm08m-ebelp&nbsp;=&nbsp;xmsel_best-ebelp.<br />
&nbsp;&nbsp;ENDIF.<br />
<br />
&nbsp;&nbsp;IF&nbsp;rbkpv-xfrbr&nbsp;=&nbsp;'X'.<br />
&nbsp;&nbsp;&nbsp;&nbsp;READ&nbsp;TABLE&nbsp;xmsel_frbr&nbsp;INDEX&nbsp;1.<br />
&nbsp;&nbsp;&nbsp;&nbsp;rm08m-frbnr&nbsp;=&nbsp;xmsel_frbr-frbnr.<br />
&nbsp;&nbsp;ENDIF.<br />
<br />
&nbsp;&nbsp;IF&nbsp;rbkpv-xlifs&nbsp;=&nbsp;'X'.<br />
&nbsp;&nbsp;&nbsp;&nbsp;READ&nbsp;TABLE&nbsp;xmsel_lifs&nbsp;INDEX&nbsp;1.<br />
&nbsp;&nbsp;&nbsp;&nbsp;rm08m-lfsnr&nbsp;=&nbsp;xmsel_lifs-lfsnr.<br />
&nbsp;&nbsp;ENDIF.<br />
<br />
&nbsp;&nbsp;IF&nbsp;rbkpv-xwerk&nbsp;=&nbsp;'X'.<br />
&nbsp;&nbsp;&nbsp;&nbsp;READ&nbsp;TABLE&nbsp;xmsel_werk&nbsp;INDEX&nbsp;1.<br />
&nbsp;&nbsp;&nbsp;&nbsp;rm08m-werks&nbsp;=&nbsp;xmsel_werk-werks.<br />
&nbsp;&nbsp;ENDIF.<br />
<br />
&nbsp;&nbsp;PERFORM&nbsp;kreditor_daten&nbsp;USING&nbsp;rbkpv-lifnr&nbsp;rbkpv-bukrs.<br />
<br />
&nbsp;&nbsp;CALL&nbsp;SCREEN&nbsp;'0100'.<br />
   </div>
   <div class="codeComment">
*  set screen '0100'.<br />
* perform call_dynpro using '0100'.<br />
<br />
   </div>
   <div class="code">
&nbsp;&nbsp;PERFORM&nbsp;rechnung_entsperren&nbsp;USING&nbsp;rbkpv-belnr&nbsp;rbkpv-gjahr.<br />
&nbsp;&nbsp;CLEAR&nbsp;ok-code.<br />
&nbsp;&nbsp;c_fcode&nbsp;=&nbsp;ok-code.<br />
&nbsp;&nbsp;IF&nbsp;c_fcode&nbsp;=&nbsp;fcook.<br />
&nbsp;&nbsp;&nbsp;&nbsp;c_rbkpv&nbsp;=&nbsp;rbkpv.<br />
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
