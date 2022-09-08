<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=GB2312" />
<title>MRM_POSITION_TREATM_MR1B</title>
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
     <td><h2>Code listing for function MRM_POSITION_TREATM_MR1B</h2>
<h3> Description: </h3></td>
   </tr>
  <tr>
     <td>
     <table class="innerTable">
       <tr>
          <td>
   <div class="code">
FUNCTION MRM_POSITION_TREATM_MR1B.<br />
   </div>
   <div class="codeComment">
*"----------------------------------------------------------------------<br />
*"*"Lokale Schnittstelle:<br />
*"       IMPORTING<br />
*"             VALUE(I_RBKPV) TYPE  MRM_RBKPV<br />
*"             VALUE(I_TCODE) LIKE  SY-TCODE<br />
*"             VALUE(I_FCODE)<br />
*"             VALUE(I_MODUS) TYPE  C<br />
*"             VALUE(I_XDBREAD) TYPE  C<br />
*"             VALUE(I_KZVERD) TYPE  C<br />
*"             VALUE(I_XBATCH) LIKE  BOOLE-BOOLE<br />
*"             VALUE(I_WERKS) LIKE  RBSELWERK-WERKS DEFAULT SPACE<br />
*"             VALUE(I_LFSNR) LIKE  RBSELLIFS-LFSNR DEFAULT SPACE<br />
*"             VALUE(I_EBELN) LIKE  RBSELBEST-EBELN DEFAULT SPACE<br />
*"             VALUE(I_MATNR) LIKE  RBVDMAT-MATNR DEFAULT SPACE<br />
*"             VALUE(I_SATNR) LIKE  RBDRSEG-SATNR DEFAULT SPACE<br />
*"             VALUE(I_MWSKZ) LIKE  RBKP-MWSKZ1 DEFAULT SPACE<br />
*"             VALUE(I_RETPO) TYPE  C DEFAULT '*'<br />
*"             VALUE(I_NETPR) LIKE  RBDRSEG-NETPR OPTIONAL<br />
*"             VALUE(I_TITELPRAEFIX) LIKE  SY-TITLE<br />
*"             VALUE(I_EXTNR) LIKE  BALHDR-EXTNUMBER DEFAULT SPACE<br />
*"             VALUE(I_XSAVED) LIKE  BOOLE-BOOLE DEFAULT X<br />
*"       EXPORTING<br />
*"             VALUE(E_FCODE)<br />
*"             VALUE(E_MODUS) TYPE  C<br />
*"             VALUE(E_BELNR) LIKE  RBKP-BELNR<br />
*"             VALUE(E_GJAHR) LIKE  RBKP-GJAHR<br />
*"             REFERENCE(E_XZUORDCHG) LIKE  MRMPO-XZUOCHG<br />
*"       TABLES<br />
*"              I_DRSEG TYPE  MMCR_TDRSEG OPTIONAL<br />
*"              T_SELBEST STRUCTURE  RBSELBEST OPTIONAL<br />
*"              T_SELFRBR STRUCTURE  RBSELFRBR OPTIONAL<br />
*"              T_SELLIFS STRUCTURE  RBSELLIFS OPTIONAL<br />
*"              T_SELWERK STRUCTURE  RBSELWERK OPTIONAL<br />
*"              T_SELERFB STRUCTURE  RBSELERFB OPTIONAL<br />
*"              TI_CHARACT STRUCTURE  RBCHARACT_INSTANCE OPTIONAL<br />
*"       EXCEPTIONS<br />
*"              RBDRSEG_NOT_FOUND<br />
*"              INVOICE_LOCKED<br />
*"----------------------------------------------------------------------<br />

<div class="codeComment">*       <a href ="global-mrm_position_treatm_mr1b.html">Global data declarations</a></div><br />
   </div>
   <div class="code">
&nbsp;&nbsp;DATA:&nbsp;l_erfpr&nbsp;LIKE&nbsp;rbkp-erfpr.<br />
&nbsp;&nbsp;data:&nbsp;begin&nbsp;of&nbsp;rbkp_objkey,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;belnr&nbsp;like&nbsp;rbkp-belnr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gjahr&nbsp;like&nbsp;rbkp-gjahr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;end&nbsp;of&nbsp;rbkp_objkey.<br />
<br />
<br />
&nbsp;&nbsp;REFRESH:&nbsp;ydrseg,&nbsp;ydrsegr,&nbsp;trbdiffko,&nbsp;trbkomv,&nbsp;tkomva,&nbsp;tkomvn,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tab_charact.<br />
&nbsp;&nbsp;CLEAR:&nbsp;&nbsp;&nbsp;ydrseg,&nbsp;ydrsegr,&nbsp;trbdiffko,&nbsp;trbkomv,&nbsp;tkomva,&nbsp;tkomvn.<br />
<br />
&nbsp;&nbsp;MOVE&nbsp;i_fcode&nbsp;TO&nbsp;ok-code.<br />
&nbsp;&nbsp;MOVE-CORRESPONDING&nbsp;i_rbkpv&nbsp;TO&nbsp;rbkpv.<br />
&nbsp;&nbsp;rbkp-erfpr&nbsp;=&nbsp;rbkpv-erfpr.<br />
<br />
   </div>
   <div class="codeComment">
*-------- Initialisierungen<br />
   </div>
   <div class="code">
&nbsp;&nbsp;CLEAR:&nbsp;rm08m,&nbsp;mrmpo.<br />
&nbsp;&nbsp;mrmpo-titlepre&nbsp;=&nbsp;i_titelpraefix.<br />
&nbsp;&nbsp;mrmpo-xzuoexe&nbsp;&nbsp;=&nbsp;'X'.<br />
&nbsp;&nbsp;mrmpo-xsaved&nbsp;&nbsp;&nbsp;=&nbsp;i_xsaved.<br />
   </div>
   <div class="codeComment">
* mrmpo-modus    = i_modus.<br />
   </div>
   <div class="code">
&nbsp;&nbsp;IF&nbsp;i_modus&nbsp;=&nbsp;c_modus_anzeigen.<br />
&nbsp;&nbsp;&nbsp;&nbsp;akt_typ&nbsp;=&nbsp;c_trtyp_a.<br />
&nbsp;&nbsp;ELSE.<br />
&nbsp;&nbsp;&nbsp;&nbsp;akt_typ&nbsp;=&nbsp;c_trtyp_v.<br />
&nbsp;&nbsp;ENDIF.<br />
&nbsp;&nbsp;mrmpo-fcode&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;i_fcode.<br />
&nbsp;&nbsp;mrmpo-xbatch&nbsp;&nbsp;&nbsp;=&nbsp;i_xbatch.<br />
&nbsp;&nbsp;mrmpo-kzverd&nbsp;&nbsp;&nbsp;=&nbsp;i_kzverd.<br />
&nbsp;&nbsp;mrmpo-iwerks&nbsp;&nbsp;&nbsp;=&nbsp;i_werks.<br />
&nbsp;&nbsp;mrmpo-ixblnr&nbsp;&nbsp;&nbsp;=&nbsp;i_lfsnr.<br />
&nbsp;&nbsp;mrmpo-iebeln&nbsp;&nbsp;&nbsp;=&nbsp;i_ebeln.<br />
&nbsp;&nbsp;mrmpo-imatnr&nbsp;&nbsp;&nbsp;=&nbsp;i_matnr.<br />
&nbsp;&nbsp;mrmpo-isatnr&nbsp;&nbsp;&nbsp;=&nbsp;i_satnr.<br />
&nbsp;&nbsp;mrmpo-iretpo&nbsp;&nbsp;&nbsp;=&nbsp;i_retpo.<br />
&nbsp;&nbsp;mrmpo-inetpr&nbsp;&nbsp;&nbsp;=&nbsp;i_netpr.<br />
&nbsp;&nbsp;mrmpo-extnr&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;i_extnr.<br />
&nbsp;&nbsp;mrmpo-imwskz&nbsp;&nbsp;&nbsp;=&nbsp;i_mwskz.<br />
&nbsp;&nbsp;CLEAR&nbsp;f_xzuordchg.<br />
<br />
&nbsp;&nbsp;IF&nbsp;mrmpo-xbatch&nbsp;IS&nbsp;INITIAL.<br />
   </div>
   <div class="codeComment">
*     falls Einstieg von der Online-Prüfung erfolgt<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;i_xdbread&nbsp;=&nbsp;space.<br />
   </div>
   <div class="codeComment">
*      Zuordnungskriterien aus Parameter-Tabellen uebernehmen<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;mrmpo-xselread&nbsp;=&nbsp;'X'.<br />
&nbsp;&nbsp;&nbsp;&nbsp;mrmpo-xzuochg&nbsp;&nbsp;=&nbsp;'X'.<br />
&nbsp;&nbsp;ELSE.<br />
   </div>
   <div class="codeComment">
*     falls Einstieg aus der Batch-#bersicht erfolgt<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;i_xdbread&nbsp;=&nbsp;'X'.<br />
&nbsp;&nbsp;&nbsp;&nbsp;mrmpo-xselread&nbsp;=&nbsp;space.<br />
&nbsp;&nbsp;&nbsp;&nbsp;mrmpo-xzuochg&nbsp;&nbsp;=&nbsp;space.<br />
&nbsp;&nbsp;&nbsp;&nbsp;mrmpo-xdb&nbsp;=&nbsp;'X'.<br />
&nbsp;&nbsp;ENDIF.<br />
<br />
&nbsp;&nbsp;PERFORM&nbsp;init_sort.<br />
<br />
   </div>
   <div class="codeComment">
* Merkmale in globale Tabelle schreiben<br />
   </div>
   <div class="code">
&nbsp;&nbsp;tab_charact[]&nbsp;=&nbsp;ti_charact[].<br />
<br />
<br />
&nbsp;&nbsp;IF&nbsp;i_xdbread&nbsp;=&nbsp;'X'.<br />
   </div>
   <div class="codeComment">
*------- Positionen aus der Datenbank bzw. internen Tabelle lesen<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;PERFORM&nbsp;rbdrseg_lesen&nbsp;USING&nbsp;i_rbkpv-belnr&nbsp;i_rbkpv-gjahr<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_kzverd&nbsp;i_werks&nbsp;i_lfsnr<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_ebeln&nbsp;i_matnr&nbsp;i_satnr&nbsp;i_mwskz&nbsp;i_retpo.<br />
&nbsp;&nbsp;&nbsp;&nbsp;IF&nbsp;akt_typ&nbsp;=&nbsp;c_trtyp_a.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;e_modus&nbsp;=&nbsp;c_modus_anzeigen.<br />
&nbsp;&nbsp;&nbsp;&nbsp;ELSE.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;e_modus&nbsp;=&nbsp;c_modus_aendern.<br />
&nbsp;&nbsp;&nbsp;&nbsp;ENDIF.<br />
&nbsp;&nbsp;ELSE.<br />
&nbsp;&nbsp;ENDIF.<br />
&nbsp;&nbsp;mrmpo-xkorrekto&nbsp;=&nbsp;rbkpv-xkorrekt.<br />
<br />
&nbsp;&nbsp;PERFORM&nbsp;read_global_data.<br />
<br />
&nbsp;&nbsp;MOVE&nbsp;space&nbsp;TO&nbsp;bearb_variante.<br />
<br />
   </div>
   <div class="codeComment">
*------- Adresse aufbereiten<br />
   </div>
   <div class="code">
&nbsp;&nbsp;PERFORM&nbsp;adresse_aufbereiten.<br />
<br />
&nbsp;&nbsp;IF&nbsp;i_rbkpv-anzunf&nbsp;&gt;&nbsp;0.<br />
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
&nbsp;&nbsp;rm08m-xiout&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;space.<br />
&nbsp;&nbsp;rm08m-xwout&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;space.<br />
<br />
&nbsp;&nbsp;akt_art&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;tcode_mr1b.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;not&nbsp;Enjoy<br />
   </div>
   <div class="codeComment">
*------- Folgedynpro aufgrund Tabelle T066 bestimmen<br />
   </div>
   <div class="code">
&nbsp;&nbsp;PERFORM&nbsp;folgedynpro&nbsp;USING&nbsp;ok-code&nbsp;bearb_variante.<br />
&nbsp;&nbsp;IF&nbsp;t066-status&nbsp;IS&nbsp;INITIAL.<br />
&nbsp;&nbsp;&nbsp;&nbsp;mrmpo-dynnr&nbsp;=&nbsp;'0204'.<br />
&nbsp;&nbsp;ELSE.<br />
&nbsp;&nbsp;&nbsp;&nbsp;mrmpo-dynnr&nbsp;=&nbsp;t066-dynnr.<br />
&nbsp;&nbsp;ENDIF.<br />
<br />
   </div>
   <div class="codeComment">
*----- Erfassungsprofil ermitteln, falls vorhanden -------------------*<br />
   </div>
   <div class="code">
&nbsp;&nbsp;CLEAR&nbsp;l_erfpr.<br />
&nbsp;&nbsp;IF&nbsp;rbkpv-erfpr&nbsp;NE&nbsp;space.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;entweder&nbsp;aus&nbsp;der&nbsp;Rechnung<br />
&nbsp;&nbsp;&nbsp;&nbsp;l_erfpr&nbsp;=&nbsp;rbkpv-erfpr.<br />
&nbsp;&nbsp;ELSE.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;oder&nbsp;direkt&nbsp;aus&nbsp;dem&nbsp;Benutzerprofil<br />
&nbsp;&nbsp;&nbsp;&nbsp;GET&nbsp;PARAMETER&nbsp;ID&nbsp;'RPR'&nbsp;FIELD&nbsp;l_erfpr.<br />
&nbsp;&nbsp;ENDIF.<br />
&nbsp;&nbsp;IF&nbsp;l_erfpr&nbsp;NE&nbsp;space.<br />
&nbsp;&nbsp;&nbsp;&nbsp;CALL&nbsp;FUNCTION&nbsp;'MRM_T169H_SINGLE_READ'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_erfpr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;l_erfpr<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;IMPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;e_t169h&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;h_t169h<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXCEPTIONS<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;entry_not_found&nbsp;=&nbsp;1<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OTHERS&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;2.<br />
&nbsp;&nbsp;&nbsp;&nbsp;IF&nbsp;(&nbsp;sy-subrc&nbsp;=&nbsp;0&nbsp;)&nbsp;AND&nbsp;(&nbsp;h_t169h-stdyn&nbsp;&lt;&gt;&nbsp;space&nbsp;).<br />
   </div>
   <div class="codeComment">
*       erste Positionsbild aus Erfassungsbild<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mrmpo-dynnr&nbsp;=&nbsp;h_t169h-stdyn.<br />
&nbsp;&nbsp;&nbsp;&nbsp;ENDIF.<br />
&nbsp;&nbsp;ENDIF.<br />
<br />
   </div>
   <div class="codeComment">
*----- generic object services<br />
   </div>
   <div class="code">
&nbsp;&nbsp;move-corresponding&nbsp;rbkpv&nbsp;to&nbsp;rbkp_objkey.<br />
&nbsp;&nbsp;call&nbsp;function&nbsp;'SWU_OBJECT_PUBLISH'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;exporting<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;objtype&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;c_objtyp_bus2081<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;objkey&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;rbkp_objkey<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;exceptions<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;objtype_not_found&nbsp;=&nbsp;1<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;others&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;2.<br />
<br />
&nbsp;&nbsp;CALL&nbsp;SCREEN&nbsp;mrmpo-dynnr.<br />
<br />
&nbsp;&nbsp;call&nbsp;function&nbsp;'SWU_OBJECT_RESTORE'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;exporting<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;objtype&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;c_objtyp_bus2081<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;objkey&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;rbkp_objkey.<br />
<br />
   </div>
   <div class="codeComment">
*------- Bestimmen des Folge-Funktionscodes<br />
   </div>
   <div class="code">
&nbsp;&nbsp;e_fcode&nbsp;=&nbsp;mrmpo-fcode.<br />
&nbsp;&nbsp;e_belnr&nbsp;=&nbsp;rbkpv-belnr.<br />
&nbsp;&nbsp;e_gjahr&nbsp;=&nbsp;rbkpv-gjahr.<br />
&nbsp;&nbsp;e_xzuordchg&nbsp;=&nbsp;f_xzuordchg.<br />
&nbsp;&nbsp;IF&nbsp;akt_typ&nbsp;=&nbsp;c_trtyp_a.<br />
&nbsp;&nbsp;&nbsp;&nbsp;e_modus&nbsp;=&nbsp;c_modus_anzeigen.<br />
&nbsp;&nbsp;ELSE.<br />
&nbsp;&nbsp;&nbsp;&nbsp;e_modus&nbsp;=&nbsp;c_modus_aendern.<br />
&nbsp;&nbsp;ENDIF.<br />
<br />
&nbsp;&nbsp;FREE&nbsp;tab_charact.<br />
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
