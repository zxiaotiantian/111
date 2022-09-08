<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=GB2312" />
<title>MRM_POSITION_TREATM</title>
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
     <td><h2>Code listing for function MRM_POSITION_TREATM</h2>
<h3> Description: </h3></td>
   </tr>
  <tr>
     <td>
     <table class="innerTable">
       <tr>
          <td>
   <div class="code">
FUNCTION mrm_position_treatm .<br />
   </div>
   <div class="codeComment">
*"----------------------------------------------------------------------<br />
*"*"Lokale Schnittstelle:<br />
*"  IMPORTING<br />
*"     VALUE(I_TCODE) LIKE  SY-TCODE<br />
*"     VALUE(I_FCODE)<br />
*"     VALUE(I_AKT_TYP) TYPE  C<br />
*"     VALUE(I_KZVERD) TYPE  C<br />
*"     VALUE(I_AGGR_LIST_VERSION) LIKE  RM08M-AGGR_LIST_VERSION<br />
*"  EXPORTING<br />
*"     VALUE(E_FCODE)<br />
*"  CHANGING<br />
*"     VALUE(X_RBKPV) TYPE  MRM_RBKPV<br />
*"  EXCEPTIONS<br />
*"      RBDRSEG_NOT_FOUND<br />
*"      INVOICE_LOCKED<br />
*"----------------------------------------------------------------------<br />

<div class="codeComment">*       <a href ="global-mrm_position_treatm.html">Global data declarations</a></div><br />
   </div>
   <div class="code">
&nbsp;&nbsp;DATA:&nbsp;BEGIN&nbsp;OF&nbsp;rbkp_objkey,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;belnr&nbsp;LIKE&nbsp;rbkp-belnr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gjahr&nbsp;LIKE&nbsp;rbkp-gjahr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;END&nbsp;OF&nbsp;rbkp_objkey.<br />
<br />
<br />
&nbsp;&nbsp;MOVE&nbsp;i_fcode&nbsp;TO&nbsp;ok-code.<br />
&nbsp;&nbsp;akt_typ&nbsp;=&nbsp;i_akt_typ.<br />
&nbsp;&nbsp;rbkpv&nbsp;=&nbsp;x_rbkpv.<br />
<br />
   </div>
   <div class="codeComment">
*-------- Initialisierungen<br />
   </div>
   <div class="code">
&nbsp;&nbsp;PERFORM&nbsp;clear_miro_mir6.<br />
&nbsp;&nbsp;CLEAR:&nbsp;rm08m,&nbsp;mrmpo,&nbsp;init_6000,&nbsp;aggr_active.<br />
&nbsp;&nbsp;CLEAR:&nbsp;cl_mrm_communication=&gt;mv_zterm_badi_upd.<br />
&nbsp;&nbsp;mrmpo-fcode&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;i_fcode.<br />
&nbsp;&nbsp;mrmpo-kzverd&nbsp;&nbsp;&nbsp;=&nbsp;i_kzverd.<br />
&nbsp;&nbsp;aggr_first_call&nbsp;=&nbsp;'X'.<br />
&nbsp;&nbsp;init&nbsp;=&nbsp;'X'.<br />
&nbsp;&nbsp;IF&nbsp;i_kzverd&nbsp;=&nbsp;c_aggregation.<br />
&nbsp;&nbsp;&nbsp;&nbsp;aggr_active&nbsp;=&nbsp;'X'.<br />
&nbsp;&nbsp;&nbsp;&nbsp;rm08m-aggr_list_version&nbsp;=&nbsp;i_aggr_list_version.<br />
&nbsp;&nbsp;ENDIF.<br />
&nbsp;&nbsp;CLEAR&nbsp;f_xzuordchg.<br />
&nbsp;&nbsp;IF&nbsp;i_akt_typ&nbsp;=&nbsp;'V'.<br />
&nbsp;&nbsp;&nbsp;&nbsp;mir4_change&nbsp;=&nbsp;'X'.<br />
&nbsp;&nbsp;ELSE.<br />
&nbsp;&nbsp;&nbsp;&nbsp;IF&nbsp;rbkpv-rbstat&nbsp;=&nbsp;c_rbstat_correc&nbsp;OR<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rbkpv-rbstat&nbsp;=&nbsp;c_rbstat_posted.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mir4_change&nbsp;=&nbsp;'X'.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;'Storno'&nbsp;im&nbsp;Menü&nbsp;erlaubt<br />
&nbsp;&nbsp;&nbsp;&nbsp;ENDIF.<br />
&nbsp;&nbsp;ENDIF.<br />
<br />
   </div>
   <div class="codeComment">
*------- Adresse aufbereiten<br />
*  PERFORM adresse_aufbereiten.<br />
<br />
   </div>
   <div class="code">
&nbsp;&nbsp;IF&nbsp;rbkpv-anzunf&nbsp;&gt;&nbsp;0.<br />
&nbsp;&nbsp;&nbsp;&nbsp;mrmpo-xunklfeh&nbsp;=&nbsp;x.<br />
&nbsp;&nbsp;ELSE.<br />
&nbsp;&nbsp;&nbsp;&nbsp;mrmpo-xunklfeh&nbsp;=&nbsp;space.<br />
&nbsp;&nbsp;ENDIF.<br />
<br />
   </div>
   <div class="codeComment">
*------- Positionsauswahl initialisieren<br />
   </div>
   <div class="code">
&nbsp;&nbsp;PERFORM&nbsp;auswahl_initialisieren.<br />
<br />
&nbsp;&nbsp;ydrseg_aktind&nbsp;=&nbsp;1.<br />
&nbsp;&nbsp;ydrseg_1stind&nbsp;=&nbsp;1.<br />
&nbsp;&nbsp;rm08m-nettosumme&nbsp;=&nbsp;rbkpv-rpzieln.<br />
&nbsp;&nbsp;PERFORM&nbsp;differenz_berechnen.<br />
&nbsp;&nbsp;rm08m-anzps&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;rbkpv-anzrpo.<br />
<br />
&nbsp;&nbsp;mrmpo-dynnr&nbsp;=&nbsp;'6000'.<br />
<br />
&nbsp;&nbsp;CALL&nbsp;SCREEN&nbsp;mrmpo-dynnr.<br />
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
&nbsp;&nbsp;CALL&nbsp;METHOD&nbsp;cl_gos_publication=&gt;unpublish(&nbsp;).<br />
<br />
   </div>
   <div class="codeComment">
*----- Trees ausschalten<br />
   </div>
   <div class="code">
&nbsp;&nbsp;IF&nbsp;dock_visible&nbsp;=&nbsp;'X'.<br />
&nbsp;&nbsp;&nbsp;&nbsp;CALL&nbsp;METHOD&nbsp;docking-&gt;set_visible<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;visible&nbsp;=&nbsp;'0'.<br />
&nbsp;&nbsp;&nbsp;&nbsp;CLEAR&nbsp;dock_visible.<br />
&nbsp;&nbsp;ENDIF.<br />
&nbsp;&nbsp;IF&nbsp;dock_v_visible&nbsp;=&nbsp;'X'.<br />
&nbsp;&nbsp;&nbsp;&nbsp;CALL&nbsp;METHOD&nbsp;docking_v-&gt;set_visible<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;visible&nbsp;=&nbsp;'0'.<br />
&nbsp;&nbsp;&nbsp;&nbsp;CLEAR&nbsp;dock_v_visible.<br />
&nbsp;&nbsp;ENDIF.<br />
<br />
   </div>
   <div class="codeComment">
*----- unlock invoice<br />
   </div>
   <div class="code">
&nbsp;&nbsp;CALL&nbsp;FUNCTION&nbsp;'DEQUEUE_E_RBKP'<br />
&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;belnr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;rbkpv-belnr<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gjahr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;rbkpv-gjahr<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;_synchron&nbsp;=&nbsp;space.<br />
<br />
   </div>
   <div class="codeComment">
*------- Bestimmen des Folge-Funktionscodes<br />
   </div>
   <div class="code">
&nbsp;&nbsp;IF&nbsp;ok-code&nbsp;=&nbsp;fcobatch&nbsp;OR<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ok-code&nbsp;=&nbsp;fcostore&nbsp;OR<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ok-code&nbsp;=&nbsp;fcomanak&nbsp;OR<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ok-code&nbsp;=&nbsp;fcobu.<br />
&nbsp;&nbsp;&nbsp;&nbsp;e_fcode&nbsp;=&nbsp;fcoback.<br />
&nbsp;&nbsp;ELSE.<br />
&nbsp;&nbsp;&nbsp;&nbsp;e_fcode&nbsp;=&nbsp;ok-code.<br />
&nbsp;&nbsp;ENDIF.<br />
&nbsp;&nbsp;x_rbkpv&nbsp;=&nbsp;rbkpv.<br />
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
