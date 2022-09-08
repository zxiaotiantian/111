<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=GB2312" />
<title>LMR1MTOP</title>
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
     <td><h2>Code listing for: LMR1MTOP</h2>
<h3> Description: </h3></td>
   </tr>
  <tr>
     <td>
     <table class="innerTable">
       <tr>
          <td>
   <div class="code">
FUNCTION-POOL mr1m       MESSAGE-ID m8.<br />
DATA  ymsel_zuord.<br />
<br />
<br />
<br />
INCLUDE mrm_types_basis.<br />
INCLUDE mrm_types_nast.                " message determination<br />
<br />
<br />
   </div>
   <div class="codeComment">
*&nbsp;Typen&nbsp;für&nbsp;Suche&nbsp;Lieferant&nbsp;in&nbsp;Mehrfachselektion<br />
   </div>
   <div class="code">
TYPE-POOLS: shlp,<br />
   </div>
   <div class="codeComment">
*&nbsp;ABAP-Typgroup&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"DPC&nbsp;EhP4<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;abap.<br />
<br />
   </div>
   <div class="codeComment">
*---------------------------------------------------------------------*<br />
*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tabellen&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*<br />
*---------------------------------------------------------------------*<br />
   </div>
   <div class="code">
TABLES:  bnka,                         " Bank<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;bsip,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;cobl,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Bestellkopf<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;bkpf,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;wegen&nbsp;DRSEG-NETWR<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ekko,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Bestellkopf<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ekpo,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Bestellposition<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;essr,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Leistungerfassungsblatt&nbsp;Kopf<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;komkbmr,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Schnittstelle&nbsp;Nachrichten&nbsp;Kopf<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;kompbmr,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Schnittstelle&nbsp;Nachrichten&nbsp;Pos.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;komk,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Kommunikationsstruktur&nbsp;Kopf<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;komp,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Kommunikationsstruk&nbsp;Konditionen<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;lfbk,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Bankverbindungen&nbsp;Kreditor<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rbkp,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Belegkopf&nbsp;Rechnungsbeleg<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rbkpb,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Rechnungsbelegkopf&nbsp;(Batch-Rech)<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rbtx,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Steuern&nbsp;Belegkopf<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rseg,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Belegpos.&nbsp;Rechnungsbeleg<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rbvs,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Split&nbsp;des&nbsp;Rechnungsbetrags<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rbws,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Quellensteuerdaten<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Eingangsrechnung&nbsp;(mit&nbsp;Split)<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tiban.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"Table&nbsp;of&nbsp;IBAN&nbsp;data.&nbsp;"Note&nbsp;957820<br />
<br />
TABLES:  tcurm,                        " Customizing MM<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tculiv,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Customizing&nbsp;Reprü<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ttxd,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;TXJCD<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t000,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Mandant<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t001,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Buchungskreis<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t001k,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Bewertungskreis<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t001u,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;BUKRS-Verrechnung<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t001w,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Werk<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t003,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;FI&nbsp;Belegarten<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t003r,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Nummernkreis<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t007a,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Steuern&nbsp;(u.a.&nbsp;für&nbsp;Fremdschlpr.)<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t007s,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Steuern&nbsp;(Texte&nbsp;für&nbsp;F4)<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t041c,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"Gründe&nbsp;für&nbsp;Storno,&nbsp;Umkehrbuchung<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t042z,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Zahlwege<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t052,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Zahlungsbedingungen<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t066,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Folgebild<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t066k,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Pop&nbsp;Up<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t163k,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Kontierungstypen&nbsp;im&nbsp;EK-Beleg<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t169,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Transaktionssteuerung<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t169f,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Vorschlag&nbsp;Belegart<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t169p,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Paramater<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t169v,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Paramater<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t169y,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Defaults&nbsp;for&nbsp;aggregation<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t685t,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Texte&nbsp;Konditionsarten<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t059u,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Texte&nbsp;Erweiterte&nbsp;Quellensteuer-<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;typen<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tmrm007a.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;MWSKZ&nbsp;in&nbsp;Reprü<br />
<br />
TABLES:  abtab,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;accit,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;acccr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;adrs,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Adresse<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;cobl_mrm_d,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Kontierungsfelder<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ek08g,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ek08r,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;drseg,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*drseg,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fin1_param,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mrm_amck,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mrm_opck,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mrm_prop,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mrm_qack,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mt08b,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mt08z,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mtcom,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mtcor,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rm08r,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rm08m,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;E/A-Felder&nbsp;SAPLMR1M<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mrmpo,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;E/A-Felder&nbsp;Positionsbild<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rm08v,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;I/O-fields&nbsp;aggregation<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;erptms_s_iv_reference,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;E/A-Fields&nbsp;TM&nbsp;&nbsp;"EhP5E<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;erptm_s_iv_data,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"TM&nbsp;EhP5e<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;nriv,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rcurr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;sgnbu,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;smbew,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;uf05a,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;vf_kred,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;View&nbsp;Kreditor<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;xsako,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Sachkontendaten<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rtax1u21.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Steuern<br />
TABLES:  help_info.                                   "retention<br />
TABLES:  dcfls_miro_multiven.          "decoupling screen 6232<br />
<br />
<br />
   </div>
   <div class="codeComment">
*eject<br />
*---------------------------------------------------------------------*<br />
*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;interne&nbsp;Tabellen&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*<br />
*---------------------------------------------------------------------*<br />
<br />
   </div>
   <div class="code">
TYPE-POOLS: mmcr, mrm, cxtab.<br />
<br />
TYPES t_drseg TYPE mmcr_drseg.<br />
TYPES: tty_drseg TYPE STANDARD TABLE OF mmcr_drseg.         " EhP5e TM<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Rechnungspositionen&nbsp;Dialog&nbsp;(angezeigte&nbsp;Positionen)&nbsp;----------*<br />
   </div>
   <div class="code">
DATA: ydrseg TYPE mmcr_drseg OCCURS 1 WITH HEADER LINE.<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Rechnungspositionen&nbsp;Dialog&nbsp;(restliche&nbsp;Positionen)&nbsp;-----------*<br />
   </div>
   <div class="code">
DATA: ydrsegr TYPE mmcr_drseg OCCURS 1 WITH HEADER LINE.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Rechnungspositionen&nbsp;Dialog&nbsp;(alle&nbsp;Positionen)&nbsp;----------------*<br />
   </div>
   <div class="code">
DATA: BEGIN OF ydrseg_cr OCCURS 1.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INCLUDE&nbsp;STRUCTURE&nbsp;drseg_cr.<br />
DATA: END OF ydrseg_cr.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Rechnungspositionen&nbsp;Dialog&nbsp;(Nullzeilen)----------------------*<br />
   </div>
   <div class="code">
DATA: null_ydrseg TYPE mmcr_drseg OCCURS 1 WITH HEADER LINE.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Rechnungspositionen&nbsp;Storno&nbsp;----------------------------------*<br />
   </div>
   <div class="code">
DATA: xdrseg TYPE mmcr_drseg OCCURS 1 WITH HEADER LINE.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Rechnungspositionen&nbsp;Dialog&nbsp;(vorl#ufig)&nbsp;----------------------*<br />
   </div>
   <div class="code">
DATA: idrseg TYPE mmcr_drseg OCCURS 100 WITH HEADER LINE.<br />
<br />
DATA: BEGIN OF idrseg_cr OCCURS 1.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INCLUDE&nbsp;STRUCTURE&nbsp;drseg_cr.<br />
DATA: END OF idrseg_cr.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Rechnungspositionen&nbsp;Dialog&nbsp;(vorl#ufig)&nbsp;----------------------*<br />
   </div>
   <div class="code">
DATA: trbdrseg TYPE mmcr_rbdrseg OCCURS 1 WITH HEADER LINE.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Rechnungsbelegpositionen&nbsp;------------------------------------*<br />
   </div>
   <div class="code">
DATA: BEGIN OF xrseg OCCURS 1.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INCLUDE&nbsp;STRUCTURE&nbsp;rseg.<br />
DATA: END OF xrseg.<br />
<br />
   </div>
   <div class="codeComment">
*---&nbsp;Invoice&nbsp;items&nbsp;for&nbsp;contract&nbsp;reference&nbsp;(dialogue)&nbsp;-----------------*<br />
   </div>
   <div class="code">
DATA gt_items_contract TYPE TABLE OF drseg.          "Contract EhP5<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Rechnungsbelegpositionen&nbsp;Multikontierung---------------------*<br />
   </div>
   <div class="code">
DATA: BEGIN OF xrbco OCCURS 1.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INCLUDE&nbsp;STRUCTURE&nbsp;rbco.<br />
DATA: END OF xrbco.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Rechnungsbeleg&nbsp;Materialbuchungen&nbsp;----------------------------*<br />
   </div>
   <div class="code">
DATA: BEGIN OF xrbma OCCURS 1.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INCLUDE&nbsp;STRUCTURE&nbsp;rbma.<br />
DATA: END OF xrbma.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;New&nbsp;Core&nbsp;Fields&nbsp;---------------------------------------------*<br />
   </div>
   <div class="code">
DATA: BEGIN OF xivext OCCURS 1.                               "NCF<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INCLUDE&nbsp;STRUCTURE&nbsp;ivext.<br />
DATA: END OF xivext.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;RWIN&nbsp;Item&nbsp;---------------------------------------------------*<br />
   </div>
   <div class="code">
DATA: BEGIN OF xaccit OCCURS 1.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INCLUDE&nbsp;STRUCTURE&nbsp;accit.<br />
DATA: END OF xaccit.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;RWIN&nbsp;W#hrung&nbsp;------------------------------------------------*<br />
   </div>
   <div class="code">
DATA: BEGIN OF xacccr OCCURS 1.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INCLUDE&nbsp;STRUCTURE&nbsp;acccr.<br />
DATA: END OF xacccr.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Currencies&nbsp;--------------------------------------------------*<br />
   </div>
   <div class="code">
DATA: BEGIN OF xcurr OCCURS 1.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INCLUDE&nbsp;STRUCTURE&nbsp;rcurr.<br />
DATA:   curtp_text LIKE dd07v-ddtext.<br />
DATA: END OF xcurr.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Mehrfachselektion&nbsp;Einkaufsbeleg&nbsp;-----------------------------*<br />
   </div>
   <div class="code">
DATA: BEGIN OF ymsel_best OCCURS 1.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INCLUDE&nbsp;STRUCTURE&nbsp;rbselbest.<br />
DATA: END OF ymsel_best.<br />
DATA: BEGIN OF xmsel_best OCCURS 1.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INCLUDE&nbsp;STRUCTURE&nbsp;rbselbest.<br />
DATA: END OF xmsel_best.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Multiple&nbsp;Selection&nbsp;Contract&nbsp;---------------------------------*<br />
   </div>
   <div class="code">
DATA: gt_ymsel_contract TYPE TABLE OF rbselcontract,   "Contract EhP5<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gt_xmsel_contract&nbsp;TYPE&nbsp;TABLE&nbsp;OF&nbsp;rbselcontract,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gt_xmsel_tm&nbsp;TYPE&nbsp;TABLE&nbsp;OF&nbsp;rbseltm.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"TM&nbsp;EhP5e<br />
<br />
TYPES: BEGIN OF ltyp_po,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;checkbox(1)&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;node_key&nbsp;TYPE&nbsp;lvc_nkey.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INCLUDE&nbsp;STRUCTURE&nbsp;mrm_f4select_contract.<br />
TYPES:  END OF ltyp_po.<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Mehrfachselektion&nbsp;Lieferschein&nbsp;------------------------------*<br />
   </div>
   <div class="code">
DATA: BEGIN OF ymsel_lifs OCCURS 1.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INCLUDE&nbsp;STRUCTURE&nbsp;rbsellifs.<br />
DATA: END OF ymsel_lifs.<br />
DATA: BEGIN OF xmsel_lifs OCCURS 1.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INCLUDE&nbsp;STRUCTURE&nbsp;rbsellifs.<br />
DATA: END OF xmsel_lifs.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Mehrfachselektion&nbsp;Erfassungsbl#tter&nbsp;-------------------------*<br />
   </div>
   <div class="code">
DATA: BEGIN OF ymsel_erfb OCCURS 1.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INCLUDE&nbsp;STRUCTURE&nbsp;rbselerfb.<br />
DATA: END OF ymsel_erfb.<br />
DATA: BEGIN OF xmsel_erfb OCCURS 1.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INCLUDE&nbsp;STRUCTURE&nbsp;rbselerfb.<br />
DATA: END OF xmsel_erfb.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Mehrfachselektion&nbsp;Frachtbrief&nbsp;-------------------------------*<br />
   </div>
   <div class="code">
DATA: BEGIN OF ymsel_frbr OCCURS 1.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INCLUDE&nbsp;STRUCTURE&nbsp;rbselfrbr.<br />
DATA: END OF ymsel_frbr.<br />
DATA: BEGIN OF xmsel_frbr OCCURS 1.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INCLUDE&nbsp;STRUCTURE&nbsp;rbselfrbr.<br />
DATA: END OF xmsel_frbr.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Mehrfachselektion&nbsp;Werk&nbsp;--------------------------------------*<br />
   </div>
   <div class="code">
DATA: BEGIN OF ymsel_werk OCCURS 1.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INCLUDE&nbsp;STRUCTURE&nbsp;rbselwerk.<br />
DATA: END OF ymsel_werk.<br />
DATA: BEGIN OF xmsel_werk OCCURS 1.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INCLUDE&nbsp;STRUCTURE&nbsp;rbselwerk.<br />
DATA: END OF xmsel_werk.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Mehrfachselektion&nbsp;Transport&nbsp;zum&nbsp;Lieferant&nbsp;-------------------*<br />
   </div>
   <div class="code">
DATA: BEGIN OF ymsel_tran OCCURS 1.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INCLUDE&nbsp;STRUCTURE&nbsp;eksel.<br />
DATA: END OF ymsel_tran.<br />
DATA: BEGIN OF xmsel_tran OCCURS 1.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INCLUDE&nbsp;STRUCTURE&nbsp;letra_iv_fields.<br />
DATA: END OF xmsel_tran.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Multiple&nbsp;Selection&nbsp;Transportation&nbsp;Management&nbsp;"EhP5&nbsp;TM&nbsp;------*<br />
   </div>
   <div class="code">
DATA: gt_xmsel_tmtran TYPE TABLE OF rbseltranspmng WITH HEADER LINE.<br />
<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Multiple&nbsp;selection&nbsp;delivery&nbsp;--------------------------------*<br />
   </div>
   <div class="code">
DATA: BEGIN OF ymsel_deli OCCURS 1.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INCLUDE&nbsp;STRUCTURE&nbsp;rbseldeli.<br />
DATA: END OF ymsel_deli.<br />
DATA: BEGIN OF xmsel_deli OCCURS 1.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INCLUDE&nbsp;STRUCTURE&nbsp;rbseldeli.<br />
DATA: END OF xmsel_deli.<br />
<br />
   </div>
   <div class="codeComment">
*--&nbsp;Bezug&nbsp;auf&nbsp;Lieferant,&nbsp;Tabelle&nbsp;Zuordnung&nbsp;---------------------------*<br />
   </div>
   <div class="code">
DATA: BEGIN OF t_msel_zuord OCCURS 1,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;xzuord&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rbkpb-xzuordli,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;xtext(20),<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;lfdatab&nbsp;&nbsp;&nbsp;LIKE&nbsp;rbkpb-lfdatabli,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;lfdatbis&nbsp;&nbsp;LIKE&nbsp;rbkpb-lfdatbisli,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;pos_shkzg&nbsp;LIKE&nbsp;rm08m-posl_shkzg,<br />
END OF t_msel_zuord.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Steuerzeilen&nbsp;------------------------------------------------*<br />
   </div>
   <div class="code">
DATA: BEGIN OF xbset OCCURS 10.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INCLUDE&nbsp;STRUCTURE&nbsp;bset.<br />
DATA: END OF xbset.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Skonto&nbsp;------------------------------------------------------*<br />
   </div>
   <div class="code">
DATA skftab LIKE rskof OCCURS 10 WITH HEADER LINE.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Kontierungen&nbsp;pro&nbsp;Rechnungszeile&nbsp;-----------------------------*<br />
   </div>
   <div class="code">
DATA drseg_co TYPE mmcr_drseg_co OCCURS 10 WITH HEADER LINE.<br />
DATA drseg_co_tmp TYPE mmcr_drseg_co OCCURS 10 WITH HEADER LINE. "MAA EhP4<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Fehlerprotokoll&nbsp;---------------------------------------------*<br />
   </div>
   <div class="code">
DATA t_errprot TYPE mrm_errprot OCCURS 100 WITH HEADER LINE.<br />
DATA t_errprot_old TYPE mrm_errprot OCCURS 100 WITH HEADER LINE.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Steuertabelle&nbsp;-----------------------------------------------*<br />
   </div>
   <div class="code">
DATA: t_rbtx   LIKE rbtx OCCURS 5 WITH HEADER LINE,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t_rbtxt&nbsp;&nbsp;LIKE&nbsp;rbtx&nbsp;OCCURS&nbsp;5&nbsp;WITH&nbsp;HEADER&nbsp;LINE.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Table&nbsp;Extended&nbsp;Withholding&nbsp;tax&nbsp;------------------------------*<br />
   </div>
   <div class="code">
DATA:  t_rbvs TYPE mrm_rbvs OCCURS 0 WITH HEADER LINE.        "Erw. Qst.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Leergut-Stuecklisten&nbsp;----------------------------------------*<br />
   </div>
   <div class="code">
DATA: t_slcomp LIKE stpob OCCURS 5 WITH HEADER LINE.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;interne&nbsp;Tabelle&nbsp;der&nbsp;abweichenden&nbsp;Regulierer&nbsp;-------------------<br />
   </div>
   <div class="code">
DATA: t_zempf LIKE izemtab OCCURS 10 WITH HEADER LINE.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;interne&nbsp;Tabelle&nbsp;der&nbsp;anzuzeigenden&nbsp;Felder&nbsp;fuer&nbsp;F4-Hilfe&nbsp;--------<br />
   </div>
   <div class="code">
DATA: f4fldtab LIKE help_value OCCURS 2 WITH HEADER LINE.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;interne&nbsp;Tabelle&nbsp;für&nbsp;allgemeine&nbsp;Werthilfe&nbsp;fuer&nbsp;F4-Hilfe&nbsp;--------<br />
   </div>
   <div class="code">
DATA:    BEGIN OF f4valtab OCCURS 10,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;feld(50)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;END&nbsp;OF&nbsp;f4valtab.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Steuerinfos&nbsp;Rechnungskürzung<br />
   </div>
   <div class="code">
DATA: kuerz_bset LIKE bset OCCURS 1 WITH HEADER LINE.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Infotabelle&nbsp;für&nbsp;Rechnungskürzung<br />
   </div>
   <div class="code">
DATA: rkatab LIKE rirk OCCURS 5 WITH HEADER LINE.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Infotabelle&nbsp;zu&nbsp;man.&nbsp;akzept.&nbsp;Differenzen&nbsp;und&nbsp;Kleindifferenzen<br />
   </div>
   <div class="code">
DATA: xtxtemp LIKE rbtx_temp OCCURS 5 WITH HEADER LINE.<br />
<br />
   </div>
   <div class="codeComment">
*&nbsp;Infotabelle&nbsp;für&nbsp;retentions&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"retention<br />
   </div>
   <div class="code">
DATA: retention TYPE mrm_t_retent.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;RWIN_CHECK&nbsp;----------------------------------------------------<br />
   </div>
   <div class="code">
DATA:    BEGIN OF tkomp OCCURS 5,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;function(30)&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;END&nbsp;OF&nbsp;tkomp.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Tabelle&nbsp;mit&nbsp;Konditionen&nbsp;-------------------------------------*<br />
   </div>
   <div class="code">
DATA:  trbkomv    LIKE rbkomv    OCCURS 1  WITH HEADER LINE,<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Preisfindung&nbsp;Kommunikations-Konditionssatz&nbsp;ALT&nbsp;--------------*<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tkomva&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;komv&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OCCURS&nbsp;1&nbsp;&nbsp;WITH&nbsp;HEADER&nbsp;LINE,<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Preisfindung&nbsp;Kommunikations-Konditionssatz&nbsp;NEU&nbsp;--------------*<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tkomvn&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;komv&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OCCURS&nbsp;1&nbsp;&nbsp;WITH&nbsp;HEADER&nbsp;LINE,<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Neue&nbsp;und&nbsp;geloeschte&nbsp;Konditionen&nbsp;-----------------------------*<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tdiffkomv&nbsp;&nbsp;LIKE&nbsp;komv&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OCCURS&nbsp;1&nbsp;&nbsp;WITH&nbsp;HEADER&nbsp;LINE,<br />
   </div>
   <div class="codeComment">
*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Konditionsaenderungen&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;trbdiffko&nbsp;&nbsp;LIKE&nbsp;rbdiffko&nbsp;&nbsp;OCCURS&nbsp;500&nbsp;&nbsp;WITH&nbsp;HEADER&nbsp;LINE.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Tabelle&nbsp;für&nbsp;#bergabe&nbsp;der&nbsp;Werte&nbsp;F4-Hilfe<br />
   </div>
   <div class="code">
DATA: BEGIN OF itab_feldnamen OCCURS 2.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INCLUDE&nbsp;STRUCTURE&nbsp;help_value.<br />
DATA: END OF itab_feldnamen.<br />
DATA: BEGIN OF itab_werte OCCURS 50,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;value(40)&nbsp;TYPE&nbsp;c.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"l#ngstes&nbsp;Feld&nbsp;aus&nbsp;Struktur<br />
DATA: END OF itab_werte.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Tabelle&nbsp;mit&nbsp;Merkmalen&nbsp;(für&nbsp;ydrseg_einschraenken)&nbsp;------------*<br />
   </div>
   <div class="code">
DATA: tab_charact TYPE rbcharact_instance_tab WITH HEADER LINE.<br />
<br />
   </div>
   <div class="codeComment">
*---&nbsp;Tab.&nbsp;mehrere&nbsp;Lieferanten&nbsp;zu&nbsp;gleicher&nbsp;Lief-/Frachtbrief-Nummer----*<br />
   </div>
   <div class="code">
DATA: BEGIN OF tab_multiven OCCURS 1,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mark,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;xblnr&nbsp;&nbsp;&nbsp;LIKE&nbsp;rm08m-lfsnr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;lifnr&nbsp;&nbsp;&nbsp;LIKE&nbsp;ekko-lifnr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;name1&nbsp;&nbsp;&nbsp;LIKE&nbsp;lfa1-name1,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ebeln&nbsp;&nbsp;&nbsp;LIKE&nbsp;ekko-ebeln,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;END&nbsp;OF&nbsp;tab_multiven.<br />
<br />
<br />
   </div>
   <div class="codeComment">
*&nbsp;Tab_value_tab&nbsp;stores&nbsp;the&nbsp;current&nbsp;screen&nbsp;variants<br />
   </div>
   <div class="code">
TYPES: BEGIN OF type_tab_value,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;scvariant&nbsp;TYPE&nbsp;shdsvtxci-scvariant,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;scvtext&nbsp;TYPE&nbsp;shdsvtxci-scvtext,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;END&nbsp;OF&nbsp;type_tab_value.<br />
<br />
TYPES: BEGIN OF type_tab_screen_variants,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;scvariant&nbsp;TYPE&nbsp;shdsvtxci-scvariant,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;scvtext&nbsp;TYPE&nbsp;shdsvtxci-scvtext,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;aggregation&nbsp;TYPE&nbsp;boole_d,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;END&nbsp;OF&nbsp;type_tab_screen_variants.<br />
<br />
DATA: tab_screen_variants TYPE TABLE OF type_tab_screen_variants<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;WITH&nbsp;HEADER&nbsp;LINE,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tab_screen_variants_aggr&nbsp;TYPE&nbsp;TABLE&nbsp;OF&nbsp;type_tab_screen_variants<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;WITH&nbsp;HEADER&nbsp;LINE.<br />
DATA: tab_shdsvtxci LIKE shdsvtxci OCCURS 0 WITH HEADER LINE.<br />
DATA: tab_shdsvci_tm   LIKE shdsvci   OCCURS 0 WITH HEADER LINE. "TM EhP5e<br />
DATA: tab_shdsvtxci_tm LIKE shdsvtxci OCCURS 0 WITH HEADER LINE. "TM EhP5e<br />
<br />
<br />
   </div>
   <div class="codeComment">
*---&nbsp;Aggregation&nbsp;lines&nbsp;to&nbsp;display&nbsp;in&nbsp;Table&nbsp;Control<br />
   </div>
   <div class="code">
TYPES: BEGIN OF type_aggr_lines,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;lsnr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rm08v-lsnr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ebeln&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rm08v-ebeln,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;werks&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rm08v-werks,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;matnr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rm08v-matnr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;uebgmat&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rm08v-uebgmat,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;satnr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rm08v-satnr,&nbsp;&nbsp;"Sammelartikel<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;xeins&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rm08v-xeins,&nbsp;&nbsp;"Einschlu#-Status<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;retpo&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rm08v-retpo,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;eindt&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rm08v-eindt,&nbsp;&nbsp;"Lieferdatum<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;menge&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rm08v-menge,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;meins&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rm08v-meins,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;bpmng&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rm08v-bpmng,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;bprme&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rm08v-bprme,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mwskz&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rm08v-mwskz,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;wrbtrb&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rm08v-wrbtrb,&nbsp;"SollBetrag,&nbsp;brutto,&nbsp;nur&nbsp;Anzeige!<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;wrbtrn&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rm08v-wrbtrn,&nbsp;"SollBetrag,&nbsp;netto<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;wmwst&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rm08v-wmwst,&nbsp;&nbsp;"Steuerbetrag<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;lieffb&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rm08v-lieffb,&nbsp;"Lieferantenfehler,&nbsp;brutto<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;lieffn&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rm08v-lieffn,&nbsp;"Lieferantenfehler,&nbsp;netto<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;txz01&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rm08v-txz01,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ean11&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rm08v-ean11,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;idnlf&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rm08v-idnlf,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;uebgtxz01&nbsp;&nbsp;LIKE&nbsp;rm08v-txz01,&nbsp;&nbsp;"Materialtext&nbsp;übergeordnetes&nbsp;Mat<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;uebgean11&nbsp;&nbsp;LIKE&nbsp;rm08v-ean11,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;uebgidnlf&nbsp;&nbsp;LIKE&nbsp;rm08v-idnlf,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;merkmal1&nbsp;&nbsp;&nbsp;LIKE&nbsp;rm08v-merkmal1,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;merkmal2&nbsp;&nbsp;&nbsp;LIKE&nbsp;rm08v-merkmal2,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;merkmal3&nbsp;&nbsp;&nbsp;LIKE&nbsp;rm08v-merkmal3,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;merkmal4&nbsp;&nbsp;&nbsp;LIKE&nbsp;rm08v-merkmal4,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;netpr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rm08v-netpr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;netprc&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rm08v-netprc,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rblgp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rbdrseg-rblgp,"eine&nbsp;Rechnungs-Position,&nbsp;die<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"in&nbsp;dieser&nbsp;TableControl-Zeile&nbsp;angezeigt&nbsp;wird<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;charact&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;rbcharact_instance&nbsp;OCCURS&nbsp;3,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"instances&nbsp;of&nbsp;characteristics<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tab_atwtb&nbsp;&nbsp;TYPE&nbsp;atwtb&nbsp;OCCURS&nbsp;4,&nbsp;&nbsp;"Merkmalsbezeichnungen<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;uebpo&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;uebpo,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"WP145920<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ebelp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;ebelp,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"WP145920<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;exlin&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;exlin,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;shkzg&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;shkzg,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"EhP6&nbsp;DInv<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;xdinv&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;xdinv,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"EhP6&nbsp;DInv<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;END&nbsp;OF&nbsp;type_aggr_lines.<br />
<br />
TYPES type_tab_aggr_lines TYPE type_aggr_lines OCCURS 10.<br />
<br />
TYPES: type_tab_svartab  TYPE svartab OCCURS 10,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;type_tab_api_char&nbsp;TYPE&nbsp;api_char&nbsp;OCCURS&nbsp;10,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;type_tab_api_vali&nbsp;TYPE&nbsp;api_vali&nbsp;OCCURS&nbsp;10,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;type_tab_ausp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;ausp&nbsp;OCCURS&nbsp;10.<br />
<br />
DATA: aggr_t_lines   TYPE type_tab_aggr_lines,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;aggr_t_lines_r&nbsp;TYPE&nbsp;type_tab_aggr_lines.&nbsp;&nbsp;"analog&nbsp;ydrseg,&nbsp;ydrsegr<br />
<br />
DATA: aggr_t_genmat_info   TYPE mrm_tab_genmat_info,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;aggr_t_charact_info&nbsp;&nbsp;TYPE&nbsp;mrm_tab_charact_info,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;aggr_t_charact_value&nbsp;TYPE&nbsp;mrm_tab_charact_value.<br />
<br />
   </div>
   <div class="codeComment">
*------&nbsp;Tabelle&nbsp;für&nbsp;die&nbsp;user-spezifischen&nbsp;Einstellungen&nbsp;MIRO<br />
   </div>
   <div class="code">
DATA:  BEGIN OF tab_user_settings OCCURS 0.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INCLUDE&nbsp;STRUCTURE&nbsp;esduscom.<br />
DATA:  END   OF tab_user_settings.<br />
<br />
   </div>
   <div class="codeComment">
*------&nbsp;Retain&nbsp;vendors&nbsp;on&nbsp;'MORE&nbsp;ALLOCATION'&nbsp;screen&nbsp;in&nbsp;MIRO&nbsp;with&nbsp;BNK<br />
   </div>
   <div class="code">
TYPES: p_orders TYPE TABLE OF ebeln INITIAL SIZE 1.<br />
<br />
DATA: BEGIN OF tab_vendor_retain OCCURS 1,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;lifnr&nbsp;TYPE&nbsp;lifnr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;po_s&nbsp;&nbsp;TYPE&nbsp;p_orders,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;END&nbsp;OF&nbsp;tab_vendor_retain.<br />
<br />
   </div>
   <div class="codeComment">
*---------------------------------------------------------------------*<br />
*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Strukturen&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*<br />
*---------------------------------------------------------------------*<br />
<br />
*--------&nbsp;Logistik-Rechnungsbelegkopf&nbsp;--------------------------------*<br />
   </div>
   <div class="code">
DATA: rbkpv  TYPE mrm_rbkpv,         " View Rechnungsbelegkopf inkl Tax<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rbkpvt&nbsp;TYPE&nbsp;mrm_rbkpvt.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;temp.&nbsp;Rechnungsbelegkopf-Daten<br />
<br />
   </div>
   <div class="codeComment">
*--------&nbsp;SCREEN-GROUP3&nbsp;Schalter&nbsp;-------------------------------------*<br />
   </div>
   <div class="code">
DATA: BEGIN OF group_schalter,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;8&nbsp;&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7&nbsp;&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;6&nbsp;&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5&nbsp;&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4&nbsp;&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3&nbsp;&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2&nbsp;&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1&nbsp;&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;END&nbsp;OF&nbsp;group_schalter.<br />
<br />
   </div>
   <div class="codeComment">
*--------&nbsp;T001-Felder&nbsp;Belegkopf&nbsp;--------------------------------------*<br />
   </div>
   <div class="code">
DATA: BEGIN OF xrbkp_t001.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INCLUDE&nbsp;STRUCTURE&nbsp;t001.<br />
DATA: END OF xrbkp_t001.<br />
<br />
   </div>
   <div class="codeComment">
*--------&nbsp;T005-Felder&nbsp;------------------------------------------------*<br />
   </div>
   <div class="code">
DATA: BEGIN OF x_t005.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INCLUDE&nbsp;STRUCTURE&nbsp;t005.<br />
DATA: END OF x_t005.<br />
<br />
DATA: h_t169h LIKE t169h.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Alte&nbsp;Zuordnungskriterien&nbsp;------------------------------------*<br />
   </div>
   <div class="code">
DATA: BEGIN OF zuord,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;lfdatabli&nbsp;&nbsp;LIKE&nbsp;rbkpv-lfdatabli,"&nbsp;Ab&nbsp;&nbsp;-&nbsp;Datum&nbsp;Lieferungen<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;lfdatbisli&nbsp;LIKE&nbsp;rbkpv-lfdatbisli,&nbsp;"&nbsp;Bis&nbsp;-&nbsp;Datum&nbsp;Lieferungen<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;lfdatabrt&nbsp;&nbsp;LIKE&nbsp;rbkpv-lfdatabrt,"&nbsp;Ab&nbsp;&nbsp;-&nbsp;Datum&nbsp;Retouren<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;lfdatbisrt&nbsp;LIKE&nbsp;rbkpv-lfdatbisrt,&nbsp;"&nbsp;Bis&nbsp;-&nbsp;Datum&nbsp;Retouren<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;xzuordli&nbsp;&nbsp;&nbsp;LIKE&nbsp;rbkpv-xzuordli,&nbsp;"&nbsp;Zuordnungskz&nbsp;Lieferungen<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;xzuordrt&nbsp;&nbsp;&nbsp;LIKE&nbsp;rbkpv-xzuordrt,&nbsp;"&nbsp;Zuordnungskz&nbsp;Retouren<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tbtkz&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rbkpv-tbtkz,&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Kz&nbsp;Nachbelastung<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;selif&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rbkpv-selif,&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;BNK-Liefeant<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;xware&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rbkpv-xware,&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Warenpositionen<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;xbnk&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rbkpv-xbnk,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;geplante&nbsp;BNK<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;END&nbsp;OF&nbsp;zuord.<br />
<br />
   </div>
   <div class="codeComment">
*&nbsp;alte&nbsp;Tabellen&nbsp;für&nbsp;Mehrfachselektion<br />
   </div>
   <div class="code">
DATA: tab_old_best LIKE xmsel_best OCCURS 1,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tab_old_lifs&nbsp;LIKE&nbsp;xmsel_lifs&nbsp;OCCURS&nbsp;1,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tab_old_erfb&nbsp;LIKE&nbsp;xmsel_erfb&nbsp;OCCURS&nbsp;1,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tab_old_frbr&nbsp;LIKE&nbsp;xmsel_frbr&nbsp;OCCURS&nbsp;1,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tab_old_werk&nbsp;LIKE&nbsp;xmsel_werk&nbsp;OCCURS&nbsp;1,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tab_old_tran&nbsp;LIKE&nbsp;xmsel_tran&nbsp;OCCURS&nbsp;1.<br />
<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;WA&nbsp;für&nbsp;XLIMIT&nbsp;-----------------------------------------------*<br />
   </div>
   <div class="code">
DATA: limit_wa TYPE mmcr_limit.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;WA&nbsp;für&nbsp;TC_MR1M-----------------------------------------------*<br />
   </div>
   <div class="code">
DATA: tc_mr1m_cols_wa TYPE cxtab_column.<br />
<br />
   </div>
   <div class="codeComment">
*---&nbsp;Workarea&nbsp;for&nbsp;table&nbsp;control&nbsp;(contract&nbsp;reference)&nbsp;-----------------*<br />
   </div>
   <div class="code">
DATA gs_items_contract TYPE drseg.                   "Contract EhP5<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Feldmofifikation&nbsp;Fi-Komponente&nbsp;------------------------------*<br />
   </div>
   <div class="code">
DATA: tab_acscr TYPE acscr OCCURS 10 WITH HEADER LINE.<br />
DATA: tab_acscr_gl TYPE acscr OCCURS 10 WITH HEADER LINE.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Immobilien&nbsp;Objekte:&nbsp;Felder&nbsp;für&nbsp;die&nbsp;exterene&nbsp;Darstellung&nbsp;-----*<br />
   </div>
   <div class="code">
DATA: s_isis_im_k_ext LIKE isis_im_k_ext.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Aggregation&nbsp;criteria&nbsp;----------------------------------------*<br />
*&nbsp;describes&nbsp;whether&nbsp;the&nbsp;single&nbsp;criteria&nbsp;are&nbsp;aggregated&nbsp;or&nbsp;not<br />
   </div>
   <div class="code">
TYPES: BEGIN OF type_aggr_criteria,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;eins&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;retpo&nbsp;&nbsp;&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;meins&nbsp;&nbsp;&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;bprme&nbsp;&nbsp;&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mwskz&nbsp;&nbsp;&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;werks&nbsp;&nbsp;&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;uebgmat&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ebeln&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;lsnr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;netpr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;c,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"Nettopreis<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;charact(4)&nbsp;&nbsp;TYPE&nbsp;c,&nbsp;&nbsp;&nbsp;"aggregation&nbsp;of&nbsp;max.&nbsp;4&nbsp;characteristics<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;matnr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;satnr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;hier&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;c,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"WP145920<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;END&nbsp;OF&nbsp;type_aggr_criteria.<br />
<br />
DATA: aggr_criteria TYPE type_aggr_criteria.<br />
<br />
   </div>
   <div class="codeComment">
*&nbsp;sorting&nbsp;criteria&nbsp;for&nbsp;aggregation&nbsp;table<br />
   </div>
   <div class="code">
TYPES: BEGIN OF type_aggr_sort_crit,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;crit1(20)&nbsp;&nbsp;TYPE&nbsp;c,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"1.&nbsp;sort&nbsp;criterion&nbsp;(field&nbsp;name)<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;crit2(20)&nbsp;&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;crit3(20)&nbsp;&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_1_asc&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;c,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"Flag:&nbsp;sort&nbsp;ascending?<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_2_asc&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_3_asc&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;END&nbsp;OF&nbsp;type_aggr_sort_crit.<br />
<br />
DATA: aggr_sort_crit TYPE type_aggr_sort_crit.<br />
<br />
DATA: tab_shdsvtxci_sk LIKE shdsvtxci OCCURS 0 WITH HEADER LINE.<br />
<br />
   </div>
   <div class="codeComment">
*&nbsp;importing&nbsp;interface&nbsp;dynpro&nbsp;6000<br />
   </div>
   <div class="code">
TYPES: BEGIN OF type_import_data_6000,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;belnr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rbkp-belnr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gjahr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rbkp-gjahr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rbstat&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rbkp-rbstat,&nbsp;&nbsp;&nbsp;&nbsp;"status&nbsp;of&nbsp;invoice<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mir4_change&nbsp;LIKE&nbsp;boole-boole,&nbsp;&nbsp;&nbsp;&nbsp;"MIR4&nbsp;call&nbsp;for&nbsp;changeable&nbsp;doc.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;aggr_list_version&nbsp;TYPE&nbsp;mrm_item_list_version,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;END&nbsp;OF&nbsp;type_import_data_6000.<br />
DATA: import_data_6000 TYPE type_import_data_6000.<br />
<br />
   </div>
   <div class="codeComment">
*-------------label&nbsp;for&nbsp;customer&nbsp;screen------------------------------*<br />
   </div>
   <div class="code">
TYPES:   BEGIN OF type_items_cust,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;label&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;string40,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;END&nbsp;OF&nbsp;type_items_cust.<br />
DATA: items_cust TYPE type_items_cust.<br />
<br />
   </div>
   <div class="codeComment">
*&nbsp;EhP6&nbsp;DInv<br />
   </div>
   <div class="code">
DATA: gv_multi_icon_text TYPE icons-text, "Text MAA button<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gv_pricing_button&nbsp;&nbsp;TYPE&nbsp;icons-text.<br />
<br />
   </div>
   <div class="codeComment">
*eject<br />
*---------------------------------------------------------------------*<br />
*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Einzelfelder&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*<br />
*---------------------------------------------------------------------*<br />
   </div>
   <div class="code">
DATA: aggr_active      TYPE c VALUE space,   "Space: No aggregation;<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"'A':&nbsp;Aggregation;&nbsp;'B':&nbsp;both&nbsp;item&nbsp;lines&nbsp;and&nbsp;aggregation<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;aggr_first_call&nbsp;&nbsp;TYPE&nbsp;c&nbsp;VALUE&nbsp;'X',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;aggr_re_evaluate&nbsp;TYPE&nbsp;c&nbsp;VALUE&nbsp;space,&nbsp;&nbsp;&nbsp;"re-evaluation&nbsp;necessary&nbsp;?<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;aggr_max_number_characts&nbsp;TYPE&nbsp;i&nbsp;VALUE&nbsp;0,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;aggr_tc_looplines&nbsp;&nbsp;TYPE&nbsp;i,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"lines&nbsp;of&nbsp;aggregation&nbsp;table&nbsp;contr<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;aggr_tc_looplines_old&nbsp;&nbsp;TYPE&nbsp;i,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;aggr_dynnr_buttons&nbsp;LIKE&nbsp;sy-dynnr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;akt_typ&nbsp;LIKE&nbsp;t169-trtyp,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;akt_art&nbsp;LIKE&nbsp;t169-trart,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;akt_fname&nbsp;LIKE&nbsp;screen-name,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;aktueller&nbsp;Feldname<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;akt_zeile&nbsp;TYPE&nbsp;i,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;aktuelle&nbsp;Zeile<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;antwort,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;anzahl&nbsp;LIKE&nbsp;sy-tfill,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;anzahl1&nbsp;LIKE&nbsp;sy-tfill,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;anzahl2&nbsp;LIKE&nbsp;sy-tfill,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;anzahl_bank&nbsp;TYPE&nbsp;i,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;anzahl_co&nbsp;TYPE&nbsp;i,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;aworg&nbsp;LIKE&nbsp;acchd-aworg,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;awtyp&nbsp;LIKE&nbsp;acchd-awtyp&nbsp;VALUE&nbsp;'RMRP&nbsp;'.<br />
ENHANCEMENT-POINT LMR1MTOP_03 SPOTS ES_SAPLMR1M STATIC .<br />
DATA: lv_active TYPE boolean.<br />
DATA: lv_longnum TYPE rm08m-longnum,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;lv_ebeln&nbsp;TYPE&nbsp;rm08m-ebeln.<br />
<br />
<br />
DATA: batcherfassung,                  " 'X' if MIRA<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;bearb_variante&nbsp;LIKE&nbsp;t066-bevar,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;betrag&nbsp;LIKE&nbsp;drseg-wrbtr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;betrag1_c(16)&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;betrag2_c(16)&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;bpmng_request,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;build_xmsel.<br />
<br />
DATA: chain_request,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;country_key&nbsp;LIKE&nbsp;t005-landk,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;csaldo(20),<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;currerr&nbsp;TYPE&nbsp;i,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;cursorfield(25).<br />
<br />
DATA: dynnr LIKE sy-dynnr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;dynnr_tab&nbsp;LIKE&nbsp;sy-dynnr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;dynnr_bezug&nbsp;LIKE&nbsp;sy-dynnr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;dynnr_ref_con&nbsp;LIKE&nbsp;sy-dynnr,&nbsp;&nbsp;"Contract&nbsp;EhP5<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;dynnr_msel_con&nbsp;LIKE&nbsp;sy-dynnr,&nbsp;"Contract&nbsp;EhP5<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;dynnr_con&nbsp;LIKE&nbsp;sy-dynnr,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"Contract&nbsp;EhP5<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;dynnr_ref_tm&nbsp;LIKE&nbsp;sy-dynnr,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"TM&nbsp;EhP5e<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;dynnr_msel_tm&nbsp;LIKE&nbsp;sy-dynnr,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"TM&nbsp;EhP5e<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;dynnr_tm&nbsp;LIKE&nbsp;sy-dynnr,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"TM&nbsp;EhP5e<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;dynnr_itemtab&nbsp;&nbsp;LIKE&nbsp;sy-dynnr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;dynnr_item&nbsp;&nbsp;LIKE&nbsp;sy-dynnr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;dynnr_items&nbsp;LIKE&nbsp;sy-dynnr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;dynnr_header_and_items&nbsp;LIKE&nbsp;sy-dynnr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;dynnr_msel&nbsp;&nbsp;LIKE&nbsp;sy-dynnr.<br />
<br />
   </div>
   <div class="codeComment">
*&nbsp;Screen&nbsp;names<br />
   </div>
   <div class="code">
DATA: gc_scr_name_po(14) TYPE c VALUE 'ITEMS_PURCHASE',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gc_scr_name_gl(18)&nbsp;TYPE&nbsp;c&nbsp;VALUE&nbsp;'ITEMS_G/L_ACCOUNT',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gc_scr_name_mat(14)&nbsp;TYPE&nbsp;c&nbsp;VALUE&nbsp;'ITEMS_MATERIAL',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gc_scr_name_cust(16)&nbsp;TYPE&nbsp;c&nbsp;VALUE&nbsp;'ITEMS_CUST-LABEL',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gc_scr_name_con(14)&nbsp;TYPE&nbsp;c&nbsp;VALUE&nbsp;'ITEMS_CONTRACT',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gc_scr_name_tm(12)&nbsp;TYPE&nbsp;c&nbsp;VALUE&nbsp;'ITEMS_TM_REF'.<br />
   </div>
   <div class="codeComment">
*&nbsp;Active&nbsp;tab&nbsp;names<br />
*&nbsp;Tab&nbsp;names<br />
   </div>
   <div class="code">
DATA: gc_tab_name_po(8) TYPE c VALUE 'ITEMS_PO',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gc_tab_name_gl(9)&nbsp;TYPE&nbsp;c&nbsp;VALUE&nbsp;'ITEMS_G/L',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gc_tab_name_mat(9)&nbsp;TYPE&nbsp;c&nbsp;VALUE&nbsp;'ITEMS_MAT',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gc_tab_name_con(9)&nbsp;TYPE&nbsp;c&nbsp;VALUE&nbsp;'ITEMS_CON',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gc_tab_name_tm(8)&nbsp;TYPE&nbsp;c&nbsp;VALUE&nbsp;'ITEMS_TM'.<br />
<br />
DATA: enjoy,                           " Enjoy-Transaktion aktiv<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ext_wt_active,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;extended&nbsp;witholding&nbsp;tax&nbsp;active<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ebeln_ebelp_request.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;EBELN/EBELP&nbsp;ge#ndert?<br />
<br />
DATA: f_dbread       LIKE boole-boole, " Flag, ob Rechnung schon gelesen<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_co_changed&nbsp;&nbsp;&nbsp;LIKE&nbsp;boole-boole,&nbsp;"&nbsp;Flag,&nbsp;ob&nbsp;DRSEG_CO&nbsp;changed<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_lines&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;i,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_prot_dyn&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;smp_dyntxt,&nbsp;&nbsp;"&nbsp;dynamischer&nbsp;Protokollbutton<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_dynpro_20x_update&nbsp;TYPE&nbsp;xfeld,&nbsp;&nbsp;"&nbsp;nettosumme_bilden&nbsp;must&nbsp;be<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;executed<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_unique&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;boole-boole,&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Hilfsvariable<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_xzuordchg&nbsp;LIKE&nbsp;mrmpo-xzuochg,&nbsp;"parameter&nbsp;for&nbsp;mrm_position_treatm<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_f4_ebeln&nbsp;&nbsp;LIKE&nbsp;boole-boole,&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;PO-Nr.&nbsp;über&nbsp;F4-Hilfe?<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_f4_ebeln_multi_request&nbsp;LIKE&nbsp;boole-boole,"&nbsp;F4-Hilfe&nbsp;über&nbsp;Mehrf.?<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_f4_lfsnr&nbsp;&nbsp;LIKE&nbsp;boole-boole,&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Lfs-Nr.&nbsp;über&nbsp;F4-Hilfe?<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_f4_vbeln&nbsp;&nbsp;LIKE&nbsp;boole-boole,&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Lieferung&nbsp;über&nbsp;F4-Hilfe&nbsp;?<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gv_f4_help_failed&nbsp;TYPE&nbsp;xfeld,&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;No&nbsp;selection&nbsp;done&nbsp;on&nbsp;F4-help<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_old_xware_xbnk&nbsp;LIKE&nbsp;rm08m-xware_bnk,&nbsp;&nbsp;"&nbsp;#nderung&nbsp;Waren&nbsp;/&nbsp;BNK<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_quantity_dist&nbsp;&nbsp;TYPE&nbsp;xfeld,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Accounting:&nbsp;Distribute&nbsp;quantity<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_amount_dist&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;xfeld,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Accounting:&nbsp;Distribute&nbsp;amount<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_quantity_amount_changed&nbsp;TYPE&nbsp;xfeld,"&nbsp;Accounting:&nbsp;Item&nbsp;changed<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_select_acc_line&nbsp;&nbsp;&nbsp;TYPE&nbsp;xfeld,"&nbsp;Accounting:&nbsp;Item&nbsp;selected<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_deselect_acc_line&nbsp;TYPE&nbsp;xfeld,"&nbsp;Accounting:&nbsp;Item&nbsp;deselected<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_select_abd&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;xfeld,"&nbsp;ABD&nbsp;-&nbsp;Item&nbsp;selected&nbsp;&nbsp;&nbsp;"MAA&nbsp;EhP4<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_deselect_abd&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;xfeld,"&nbsp;ABD&nbsp;-&nbsp;Item&nbsp;deselected&nbsp;"MAA&nbsp;EhP4<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_quantity_dist_abd&nbsp;TYPE&nbsp;xfeld,"&nbsp;ABD&nbsp;-&nbsp;Amount&nbsp;changed&nbsp;&nbsp;"MAA&nbsp;EhP4<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_lfsnr_del&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_old_menge&nbsp;TYPE&nbsp;mmcr_drseg-menge,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_old_bpmng&nbsp;TYPE&nbsp;mmcr_drseg-bpmng,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_old_wrbtr&nbsp;TYPE&nbsp;mmcr_drseg-wrbtr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_mac&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;c,<br />
   </div>
   <div class="codeComment">
*&nbsp;not&nbsp;possible&nbsp;to&nbsp;change&nbsp;parked&nbsp;invoice&nbsp;with&nbsp;MIR5<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_nochange&nbsp;&nbsp;TYPE&nbsp;boole-boole,<br />
   </div>
   <div class="codeComment">
*&nbsp;update&nbsp;data&nbsp;on&nbsp;tab&nbsp;'contact'&nbsp;at&nbsp;PBO<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_update_contdata&nbsp;TYPE&nbsp;c,<br />
   </div>
   <div class="codeComment">
*&nbsp;customer&nbsp;data&nbsp;changed&nbsp;on&nbsp;customer&nbsp;screen<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_customdata_changed&nbsp;TYPE&nbsp;boole-boole,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_tculiv_found&nbsp;TYPE&nbsp;xfeld,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"MAA&nbsp;EhP4<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_dpc_dyn&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;smp_dyntxt,&nbsp;&nbsp;&nbsp;"dyn.&nbsp;DPC-Button&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"DPC&nbsp;EhP4<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_dpc_visible&nbsp;TYPE&nbsp;abap_bool.&nbsp;&nbsp;&nbsp;&nbsp;"Button&nbsp;visibility&nbsp;&nbsp;&nbsp;"DPC&nbsp;EhP4<br />
<br />
DATA: gv_f4_contract TYPE boole-boole,           "Contracts EhP5<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gv_f4_srm_contract_6310&nbsp;TYPE&nbsp;xfeld,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"Contracts&nbsp;EhP5<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gv_contractreferencetype_old(1)&nbsp;TYPE&nbsp;c.&nbsp;&nbsp;&nbsp;&nbsp;"Contracts&nbsp;EhP5<br />
DATA: gv_line_6320 TYPE i,                       "Contracts EhP5<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gv_field&nbsp;TYPE&nbsp;string,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"Contracts&nbsp;EhP5<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gt_service_ek08rn&nbsp;TYPE&nbsp;STANDARD&nbsp;TABLE&nbsp;OF&nbsp;mmcr_ek08rn.&nbsp;"Contracts&nbsp;Ehp5<br />
<br />
   </div>
   <div class="codeComment">
*&nbsp;User-ID&nbsp;for&nbsp;TM&nbsp;invoice&nbsp;clerk,<br />
   </div>
   <div class="code">
DATA: gv_tm_invoice_clerk TYPE usr05-parva,                "EhP5e TM 8.0<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gv_hit_field_6330(30),<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gv_hit_line_6330&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;i,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gv_line_6330&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;i.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"EhP5e<br />
<br />
DATA: hit_field(20),                   " Trefferfeld<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;hit_line&nbsp;TYPE&nbsp;i,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Trefferzeile<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;hit_line_old&nbsp;TYPE&nbsp;i.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;letzte&nbsp;Trefferzeile<br />
<br />
DATA: h_rbkpv LIKE rbkpv,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h_modus,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Modus&nbsp;für&nbsp;MRM_CREATE_INVOICE:<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;1&nbsp;-&nbsp;Storno<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h_xnegp&nbsp;LIKE&nbsp;xaccit-xnegp,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Kz:&nbsp;Negativbuchung<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h_kzmek&nbsp;LIKE&nbsp;drseg-kzmek,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Hilfsfeld&nbsp;für&nbsp;Korrekturkz<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h_menge&nbsp;LIKE&nbsp;drseg-menge,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Hilfsfeld&nbsp;für&nbsp;Menge<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h_bpmng&nbsp;LIKE&nbsp;drseg-bpmng,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Hilfsfeld&nbsp;für&nbsp;BP-Menge<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h_wrbtr&nbsp;LIKE&nbsp;drseg-wrbtr,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Hilfsfeld&nbsp;für&nbsp;Betrag<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h_netpr&nbsp;LIKE&nbsp;ekpo-netpr,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Hilfsfeld&nbsp;für&nbsp;Nettopreis<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h_knumv&nbsp;LIKE&nbsp;rbkpv-knumve,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Hilfsfeld&nbsp;für&nbsp;KNUMV<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h_rblgp&nbsp;LIKE&nbsp;drseg-rblgp,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Hilfsfeld&nbsp;für&nbsp;RBLGP<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h_dynnr&nbsp;LIKE&nbsp;sy-dynnr,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Hilfsfeld&nbsp;für&nbsp;Steuer-Dynpros<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h_display&nbsp;TYPE&nbsp;c,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Hilfsfeld&nbsp;für&nbsp;Sperre&nbsp;PO<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h_no_ebeln&nbsp;TYPE&nbsp;c,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Hilfsfeld&nbsp;für&nbsp;archivierte&nbsp;PO<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h_ebeln_noheader&nbsp;LIKE&nbsp;drseg-ebeln.&nbsp;"&nbsp;Hilfsfeld&nbsp;für&nbsp;PO&nbsp;Nummer<br />
<br />
DATA: h_kred LIKE rbkpv-lifnr,         " Hilfsfeld für Lieferant<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h_kred_not_ok&nbsp;LIKE&nbsp;rbkpv-lifnr.&nbsp;&nbsp;"&nbsp;Hilfsfeld&nbsp;ungültiger&nbsp;Lieferant<br />
DATA: f_waers LIKE rbkpv-waers.        " Hilfsfeld für W#hrung<br />
DATA: h_superfield LIKE rm08m-superfield.  "Merkfeld für vendor_search<br />
   </div>
   <div class="codeComment">
*--------fields&nbsp;to&nbsp;activate&nbsp;customer&nbsp;screen---------------------------*<br />
   </div>
   <div class="code">
DATA: h_label TYPE string40,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h_cust_data_active&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h_first&nbsp;TYPE&nbsp;c&nbsp;VALUE&nbsp;'X',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h_first_6000&nbsp;TYPE&nbsp;c&nbsp;VALUE&nbsp;'X',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h_program&nbsp;TYPE&nbsp;program,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h_screen&nbsp;TYPE&nbsp;dynnr.<br />
<br />
DATA: i TYPE i,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;idx&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;sy-tabix,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;index&nbsp;&nbsp;&nbsp;LIKE&nbsp;sy-index,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;init,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Flag&nbsp;für&nbsp;BELEGKOPF_VORSCHLAG<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;init_6000.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Transaktion&nbsp;initialisieren<br />
<br />
DATA: gv_transact_start TYPE xfeld,    " Flag for starting transaction<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gv_transact_start_verify&nbsp;TYPE&nbsp;xfeld.&nbsp;"Compare&nbsp;field&nbsp;transaction&nbsp;start<br />
<br />
TYPES: BEGIN OF tmp_rbkpv,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rbkpv&nbsp;&nbsp;&nbsp;TYPE&nbsp;mrm_rbkpv,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;kufix&nbsp;&nbsp;&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;vf_kred&nbsp;TYPE&nbsp;vf_kred,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rm08m&nbsp;&nbsp;&nbsp;TYPE&nbsp;rm08m,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;END&nbsp;OF&nbsp;tmp_rbkpv.<br />
DATA: h_tmp_rbkpv TYPE tmp_rbkpv.<br />
<br />
DATA: ktrtyp LIKE t185f-trtyp,         " Transaktionstyp Konditione<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;kufix,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Flag&nbsp;Kurs&nbsp;fixiert<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;kurstyp&nbsp;LIKE&nbsp;acccr-curtp,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Kurstyp&nbsp;für&nbsp;Simulieren<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;kursanz&nbsp;LIKE&nbsp;sy-tfill,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Anzahl&nbsp;Kurstyp&nbsp;für&nbsp;Simulieren<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;kurstyp_text&nbsp;LIKE&nbsp;dd07v-ddtext,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;kzkon&nbsp;TYPE&nbsp;c,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Kz,&nbsp;welche&nbsp;Konditionen&nbsp;lesen<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;kzmek_request.<br />
<br />
DATA: lines LIKE sy-tfill,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;loopc&nbsp;LIKE&nbsp;sy-loopc,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gv_loopc_6320&nbsp;LIKE&nbsp;sy-loopc,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"Contract&nbsp;EhP5<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gv_loopc_6330&nbsp;LIKE&nbsp;sy-loopc.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"TM&nbsp;EhP5e<br />
<br />
DATA: menge_request,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;message_text(60),<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mir4_change&nbsp;LIKE&nbsp;boole-boole,&nbsp;&nbsp;&nbsp;&nbsp;"MIR4&nbsp;Beleg&nbsp;weiterbearbeitbar<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mir5_nochange&nbsp;LIKE&nbsp;boole-boole,&nbsp;&nbsp;"not&nbsp;possible&nbsp;to&nbsp;change&nbsp;invoice<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;monat&nbsp;LIKE&nbsp;accit-monat,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;msgty_attenuate,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_scvtext&nbsp;LIKE&nbsp;shdsvtxci-scvtext.<br />
<br />
DATA: ok-code(20),<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ok-code_500(4),<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;old_item_list_version&nbsp;LIKE&nbsp;rm08m-item_list_version.<br />
<br />
DATA: parva        LIKE xu350-parva,   " Benutzerparameter<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;percentage1&nbsp;&nbsp;TYPE&nbsp;p&nbsp;DECIMALS&nbsp;0,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;percentage2&nbsp;&nbsp;TYPE&nbsp;p&nbsp;DECIMALS&nbsp;0,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;potenz&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;&nbsp;i,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;progn&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;sy-cprog,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;progn_tab&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;sy-cprog,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;progn_itemtab&nbsp;LIKE&nbsp;sy-cprog.<br />
<br />
DATA: rbauswp  TYPE c,                 " Auswirkungskz Aktuelle Position<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rbauswr&nbsp;&nbsp;TYPE&nbsp;c,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Auswirkungskz&nbsp;Alle&nbsp;Positionen<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rbausws&nbsp;&nbsp;TYPE&nbsp;c,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Auswirkungskz&nbsp;Selektion<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rbmng_request,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rcurr_pagind&nbsp;TYPE&nbsp;i&nbsp;VALUE&nbsp;1,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rcurr_aktind&nbsp;TYPE&nbsp;i&nbsp;VALUE&nbsp;1,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rbtx_pagind&nbsp;TYPE&nbsp;i&nbsp;VALUE&nbsp;1,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rbtx_aktind&nbsp;TYPE&nbsp;i&nbsp;VALUE&nbsp;1,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rbwwr_request,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rc&nbsp;LIKE&nbsp;sy-subrc,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;reference_request,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;referenzbelegtyp_old,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_referenzbelegtyp&nbsp;type&nbsp;C&nbsp;value&nbsp;'&nbsp;'.<br />
<br />
DATA: save_wrbtr LIKE cobl-wrbtr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;save_saknr&nbsp;LIKE&nbsp;cobl-saknr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;save_bukrs&nbsp;LIKE&nbsp;cobl-bukrs,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;sel_line&nbsp;LIKE&nbsp;sy-stepl,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;simulation,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;st_belnr&nbsp;LIKE&nbsp;rbkp-belnr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;st_gjahr&nbsp;LIKE&nbsp;rbkp-gjahr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;storno_xabwd(1)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;c,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Kz:&nbsp;Abw.&nbsp;Buchungsdat.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;suppress_dialog(1)&nbsp;TYPE&nbsp;c.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"Kz:&nbsp;Dynpro&nbsp;dunkel&nbsp;prozessiren<br />
<br />
DATA: title(120)  TYPE c,              " Titlebar            Note 430490<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;telephony_active,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;textperc(3)&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;text(80)&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;trtype_changed.<br />
<br />
DATA: vendor_screen LIKE sy-dynnr.<br />
<br />
DATA: wa_rbtx LIKE rbtx,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;wrbtr_manuell,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;wrbtr_request.<br />
<br />
DATA: xaccit_aktind TYPE i VALUE 1,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;xaccit_pagind&nbsp;TYPE&nbsp;i&nbsp;VALUE&nbsp;1,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;xerror&nbsp;LIKE&nbsp;boole-boole,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Flag,&nbsp;geaendert<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;xstvr,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;KZ&nbsp;Steuer&nbsp;ver#ndert<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;xflag,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Hilfsflag<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;xware_bnk_request.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Waren/BNK&nbsp;ge#ndert<br />
<br />
DATA: ydrseg_aktind TYPE i VALUE 1,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ydrseg_1stind&nbsp;TYPE&nbsp;i&nbsp;VALUE&nbsp;1,&nbsp;&nbsp;&nbsp;&nbsp;"Index&nbsp;der&nbsp;ersten&nbsp;Position<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ydrseg_index&nbsp;&nbsp;TYPE&nbsp;i,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ymsel_aktind&nbsp;TYPE&nbsp;i&nbsp;VALUE&nbsp;1,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"Dynp&nbsp;55x:&nbsp;Steploop-Index<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ymsel_pagind&nbsp;TYPE&nbsp;i&nbsp;VALUE&nbsp;1.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Seiten-Index<br />
<br />
DATA: h_kalsm LIKE t007a-kalsm,        "Steuerschema<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h_kalsm_ttxd&nbsp;LIKE&nbsp;ttxd-kalsm.&nbsp;&nbsp;&nbsp;&nbsp;"Steuerschema<br />
<br />
DATA: zeile TYPE i.<br />
<br />
DATA: gf_tc_active TYPE boole-boole.     " RE<br />
<br />
   </div>
   <div class="codeComment">
*&nbsp;globale&nbsp;Variablen:&nbsp;Archivname&nbsp;(bei&nbsp;Anzeigen&nbsp;ReBeleg&nbsp;aus&nbsp;Archiv)<br />
   </div>
   <div class="code">
DATA: g_archivname LIKE admi_files-archiv_key VALUE space.<br />
   </div>
   <div class="codeComment">
*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;display&nbsp;from&nbsp;archive?<br />
   </div>
   <div class="code">
DATA: g_archive_display TYPE boole-boole.<br />
<br />
INCLUDE lmr1md05.<br />
<br />
   </div>
   <div class="codeComment">
*&nbsp;global&nbsp;fields&nbsp;for&nbsp;barcode&nbsp;insert<br />
   </div>
   <div class="code">
DATA: g_barcode LIKE toav0-arc_doc_id, " barcode<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;g_doctype&nbsp;LIKE&nbsp;toaom-ar_object.&nbsp;&nbsp;"&nbsp;document&nbsp;type<br />
<br />
   </div>
   <div class="codeComment">
*&nbsp;Hilfvariable&nbsp;für&nbsp;Erweiterte&nbsp;Quellensteuer&nbsp;und&nbsp;Split&nbsp;Kreditorzeile<br />
*&nbsp;Help&nbsp;variables&nbsp;for&nbsp;extended&nbsp;withholding&nbsp;tax&nbsp;solution&nbsp;and&nbsp;vendorsplit<br />
<br />
   </div>
   <div class="code">
DATA:  h_bukrs         LIKE rbkp-bukrs,"Erw. Qst.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h_lifnr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rbkp-lifnr,"Erw.&nbsp;Qst.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h_budat&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rbkp-budat,"Erw.&nbsp;Qst.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h_belnr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rbkp-belnr,"Erw.&nbsp;Qst.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h_gjahr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rbkp-gjahr,"Erw.&nbsp;Qst.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h_wt_dynnr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;sy-dynnr,&nbsp;&nbsp;"Erw.&nbsp;Qst.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rbvslines&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;sy-tabix,&nbsp;&nbsp;"Split<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;split&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code,&nbsp;&nbsp;&nbsp;"Split<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rbvssum&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rbvs-srmwwr,&nbsp;"sum&nbsp;to&nbsp;check&nbsp;split&nbsp;amounts<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rbvsdelta(21)&nbsp;&nbsp;&nbsp;TYPE&nbsp;c,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"delta&nbsp;between&nbsp;sum&nbsp;of&nbsp;split<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"amounts&nbsp;and&nbsp;gross&nbsp;amount<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;wt_change&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;c,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"indicator:&nbsp;change&nbsp;withholding<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"tax&nbsp;due&nbsp;to&nbsp;vendor&nbsp;change<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;real_lifnr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;rbkp-lifnr,"account&nbsp;to&nbsp;be&nbsp;used&nbsp;for&nbsp;wt<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"purposes&nbsp;in&nbsp;case&nbsp;of&nbsp;vendors<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"posting&nbsp;to&nbsp;a&nbsp;head&nbsp;office<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mwskz_on&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;sy-tabix.&nbsp;&nbsp;"split:&nbsp;number&nbsp;of&nbsp;lines&nbsp;with<br />
"taxcode<br />
<br />
   </div>
   <div class="codeComment">
*&nbsp;Hilfvariable&nbsp;für&nbsp;user_settings<br />
   </div>
   <div class="code">
DATA: h_uname LIKE esdus-uname,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h_element&nbsp;LIKE&nbsp;esdus-element,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h_active&nbsp;&nbsp;LIKE&nbsp;esdus-active.<br />
<br />
   </div>
   <div class="codeComment">
*&nbsp;Storno&nbsp;Buchungsdatum<br />
   </div>
   <div class="code">
DATA: g_budat LIKE rbkp_v-budat.<br />
   </div>
   <div class="codeComment">
*&nbsp;Document&nbsp;date&nbsp;Reversal&nbsp;Document<br />
   </div>
   <div class="code">
DATA: g_bldat LIKE rbkp_v-bldat.<br />
<br />
   </div>
   <div class="codeComment">
*&nbsp;Document&nbsp;type&nbsp;used&nbsp;for&nbsp;Barcode&nbsp;Popup<br />
   </div>
   <div class="code">
DATA: barc_blart LIKE rbkpv-blart.<br />
<br />
   </div>
   <div class="codeComment">
*&nbsp;Global&nbsp;variable&nbsp;for&nbsp;one&nbsp;time&nbsp;vendor&nbsp;check&nbsp;(form&nbsp;ota_check&nbsp;in&nbsp;MR1M)<br />
   </div>
   <div class="code">
DATA: gf_ota_check  TYPE char1 VALUE 'X'.<br />
<br />
   </div>
   <div class="codeComment">
*&nbsp;Reverse&nbsp;and&nbsp;Copy;&nbsp;dynamical&nbsp;menu&nbsp;entry<br />
   </div>
   <div class="code">
DATA: g_menu_cancel_copy TYPE gui_text.<br />
<br />
   </div>
   <div class="codeComment">
*&nbsp;Retentions<br />
   </div>
   <div class="code">
DATA: g_retpc_request  TYPE char1,                     "retention<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;g_retamt_request&nbsp;TYPE&nbsp;char1.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"retention<br />
<br />
   </div>
   <div class="codeComment">
*&nbsp;Contracts<br />
   </div>
   <div class="code">
DATA: gv_con_number_request TYPE char1,             " Contract EhP5<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gv_con_item_request&nbsp;TYPE&nbsp;char1,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gv_srm_con_number_request&nbsp;TYPE&nbsp;char1,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gv_srm_con_item_request&nbsp;TYPE&nbsp;char1,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gv_ref_con_request&nbsp;TYPE&nbsp;xfeld.<br />
<br />
   </div>
   <div class="codeComment">
*&nbsp;MSR<br />
   </div>
   <div class="code">
DATA: g_save_ok_code    LIKE ok-code.<br />
<br />
   </div>
   <div class="codeComment">
*&nbsp;TM&nbsp;Transportation&nbsp;Management<br />
   </div>
   <div class="code">
DATA: gv_ref_tm_request,                           "TM switch<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gv_tm_reference_document_old(1)&nbsp;TYPE&nbsp;c.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"EhP5e<br />
DATA: gv_tm_rbkpv_selif TYPE selif.<br />
<br />
   </div>
   <div class="codeComment">
*&nbsp;Variables&nbsp;for&nbsp;the&nbsp;first&nbsp;call&nbsp;of&nbsp;the&nbsp;MAA&nbsp;screen<br />
   </div>
   <div class="code">
DATA: gv_firstcall_acc TYPE c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gv_secondcall_acc&nbsp;TYPE&nbsp;c.<br />
<br />
   </div>
   <div class="codeComment">
*eject<br />
*---------------------------------------------------------------------*<br />
*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXIT&nbsp;Commands&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*<br />
*---------------------------------------------------------------------*<br />
<br />
   </div>
   <div class="code">
DATA: exit_abbr(4)         VALUE 'ABBR',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;exit_esc(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'ESC',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;exit_back(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'BACK',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;exit_ekbe(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'EKBE',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;exit_ende(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'ENDE',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;exit_erfp(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'ERFP',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;exit_kdat(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'KDAT',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;exit_meld(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'MELD',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;exit_me23(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'ME23',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;exit_ml82(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'ML82',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;exit_mr1g(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'MR1G',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;exit_mr1m(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'MR1M',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;exit_mr2m(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'MR2M',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;exit_mr3m(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'MR3M',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;exit_mr5m(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'MR5M'.<br />
<br />
   </div>
   <div class="codeComment">
*---------------------------------------------------------------------*<br />
*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FCODEs&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*<br />
*---------------------------------------------------------------------*<br />
   </div>
   <div class="code">
CONSTANTS:<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoab(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'AB&nbsp;&nbsp;',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoadma(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'ADMA',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoaend(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'AEND',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoamar(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'AMAR',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoassignment_upd&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'ASSIGN_UPD',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoback(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'BACK',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcobu(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'BU&nbsp;&nbsp;',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcobatch&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'BATCH',"&nbsp;Hintergrund<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcocanc(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'CANC',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcochav(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'CHAV',&nbsp;"&nbsp;#ndern&nbsp;&lt;-&gt;&nbsp;Anzeigen<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcochng(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'CHNG',&nbsp;"&nbsp;#nderungsbelege&nbsp;anzeigen<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcocncl(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'CNCL',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcocomp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'COMP',&nbsp;"&nbsp;Vollst#ndig&nbsp;sichern<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcocrea_iteml&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'CREA_ITEML',&nbsp;"&nbsp;Pos.liste<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoddwl&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'DDWL',&nbsp;"&nbsp;compare&nbsp;GR&nbsp;quantity<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcodele&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'DELE',&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;L#schen&nbsp;Beleg<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcodisp(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'DISP',&nbsp;"&nbsp;Mehrfachzuordg,&nbsp;Best&nbsp;anzeigen<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcodoc(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'DOC&nbsp;',&nbsp;&nbsp;"Beleg&nbsp;anzeigen/#ndern<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcodtrc(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'DTRC',&nbsp;&nbsp;&nbsp;"MSR:&nbsp;display&nbsp;of&nbsp;tracking&nbsp;data<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcodummy&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'DUMMY',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoende(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'ENDE',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcofbl1(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'FBL1',&nbsp;"&nbsp;Kreditorenposten<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoheader_collapse&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'HEADER_COLLAPSE',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoheader_contact&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'HEADER_CONTACT',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoheader_expand&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'HEADER_EXPAND',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoheader_fi&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'HEADER_FI',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoheader_note&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'HEADER_NOTE',&nbsp;"&nbsp;Notiz<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoheader_pay&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'HEADER_PAY',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoheader_tax&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'HEADER_TAX',&nbsp;"&nbsp;Steuern<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoheader_split&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'HEADER_SPLIT',&nbsp;"&nbsp;Split<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoheader_total&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'HEADER_TOTAL',&nbsp;"&nbsp;Grunddaten<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoheader_wt&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'HEADER_WT',&nbsp;"&nbsp;Quellensteuer<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoinfo(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'INFO',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoj1bn(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'J1BN',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcokont(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'KONT',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcokdat(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'KDAT',&nbsp;"&nbsp;Kreditor&nbsp;Daten<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcokorr(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'KORR',&nbsp;"&nbsp;Korrekturkennzeichen&nbsp;setzen<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoldel(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'LDEL',&nbsp;"&nbsp;Mehrfachzuordg,&nbsp;Zeile&nbsp;l#schen<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcolistversion&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'LIST_VERSION',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcolistversion_aggr&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'LIST_VERSION_AGGR',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcomanak&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'MANAK',&nbsp;"&nbsp;Manuell&nbsp;akzeptiert<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcomehr_bank&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'MEHR_BANK',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcomess_buyer&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'MESS_BUYER',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcomess_receiver&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'MESS_RECEIVER',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcomess_inv_enter&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'MESS_INV_ENTER',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcomess_user&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'MESS_USER',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcomess_vendor_email&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'MESS_VENDOR_EMAIL',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcomess_vendor_fax&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'MESS_VENDOR_FAX',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcomess_copy_enter&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'MESS_COPY_ENTER',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcomir7(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'MIR7',&nbsp;&nbsp;"Change&nbsp;to&nbsp;transaction&nbsp;MIRO<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcomsbe(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'MSBE',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcomseb(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'MSEB',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcomsel(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'MSEL',&nbsp;"&nbsp;Dummy&nbsp;für&nbsp;Listbox<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcomselcon(8)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'MSEL_CON',&nbsp;&nbsp;"Contract&nbsp;EhP5<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcomseltm(8)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'MSEL_TM',&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"TM&nbsp;EhP5e<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcomsfr(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'MSFR',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcomsgh(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'MSGH',&nbsp;"&nbsp;message&nbsp;header<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcomsgi(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'MSGI',&nbsp;"&nbsp;message&nbsp;item<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcomsls(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'MSLS',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcomsdl(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'MSDL',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcomswk(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'MSWK',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fconewl(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'NEWL',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fconewcc&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'NEWCC',&nbsp;"&nbsp;neuer&nbsp;Buchungskreis<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fconota_fiscal&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'J1BN',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoobj(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'OBJ',"&nbsp;Objektverknüpfung<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcook(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'OK&nbsp;&nbsp;',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoonet(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'ONET',&nbsp;"&nbsp;one&nbsp;time&nbsp;vendor&nbsp;data<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcopark&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'PARK',&nbsp;&nbsp;"&nbsp;Beleg&nbsp;vorerfassen<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcopb(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'PB&nbsp;&nbsp;',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcopick&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'PICK',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcopicw(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'PICW',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcophone_call_vendor&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'PHONE_CALL_VENDOR',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcopkoe(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'PKOE',&nbsp;"&nbsp;eigene&nbsp;Konditionsfehler<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcopkol(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'PKOL',&nbsp;"&nbsp;Lieferanten-Konditionsf.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcopos&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'POS',&nbsp;"&nbsp;positionieren<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoppch&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'PPCH',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcopruefen&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'PRUEFEN',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcopvv(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'P--&nbsp;',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcopv(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'P-&nbsp;&nbsp;',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcopn(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'P+&nbsp;&nbsp;',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcopnn(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'P++&nbsp;',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoprot(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'PROT',&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;alle&nbsp;Meldungen<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoprotdyn(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'PRON',&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;alle&nbsp;Meldungen<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcorban(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'RBAN',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcorbkp(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'RBKP',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoread_text&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'READ_TEXT',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcorefresh&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'REFRESH',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcodeupdateacc&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'ACC_UPDATE',&nbsp;"MAA&nbsp;screen,&nbsp;EhP5e,&nbsp;Update&nbsp;Account&nbsp;Assignments<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcorwbl(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'RWBL',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcosearch&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'SEARCH',&nbsp;"&nbsp;Suche<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcosearch_next&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'SEARCH_NEXT',&nbsp;"&nbsp;Suche<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcosich(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'SICH',&nbsp;"&nbsp;save&nbsp;out&nbsp;of&nbsp;messaging<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcosort_a&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'SORT_A',&nbsp;"sortieren&nbsp;aufsteigend<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcosort_a_aggr&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'SORT_A_AGGR',&nbsp;"sort&nbsp;in&nbsp;aggreg<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcosort_d&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'SORT_D',&nbsp;"sortieren&nbsp;abteigend<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcosort_d_aggr&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'SORT_D_AGGR',&nbsp;"sort&nbsp;in&nbsp;aggreg<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcostore&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'STORE',&nbsp;"&nbsp;merken<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcosort(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'SORT',&nbsp;"&nbsp;Mehrfachzuordg,&nbsp;Sortieren<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcotax(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'TAX&nbsp;',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcotree(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'TREE',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcotreev(5)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'TREEV',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcotror(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'TROR',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoufef(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'UFEF',&nbsp;"&nbsp;Eigener&nbsp;Fehler<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoufeh(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'UFEH',&nbsp;"&nbsp;Sortierung&nbsp;ungekl#rte&nbsp;Fehler<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcouflf(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'UFLF',&nbsp;"&nbsp;Lieferantenfehler<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoupda(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'UPDA',&nbsp;"&nbsp;#ndern&nbsp;Rechnungsbeleg<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcovendor&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'VENDOR',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoview(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'VIEW',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcowaer(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'WAER',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcozuor(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'ZUOR',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcozuon(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'ZUON',&nbsp;"&nbsp;mehr&nbsp;Bezüge<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcozuow(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VALUE&nbsp;'ZUOW',&nbsp;"&nbsp;weniger&nbsp;Bezüge<br />
   </div>
   <div class="codeComment">
*&nbsp;für&nbsp;Prototyp&nbsp;Direktbuchen<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoitems_po&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'ITEMS_PO',&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;PO&nbsp;tab<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoitems_gl&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'ITEMS_G/L',&nbsp;&nbsp;&nbsp;"&nbsp;GL&nbsp;tab<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoitems_mat&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'ITEMS_MAT',&nbsp;&nbsp;&nbsp;"&nbsp;Material&nbsp;tab<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoitems_asset&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'ITEMS_ASSET',&nbsp;"&nbsp;Anlage<br />
   </div>
   <div class="codeComment">
*&nbsp;customer&nbsp;screen&nbsp;in&nbsp;MIRO<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoitems_cust&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'ITEMS_CUST',&nbsp;&nbsp;"&nbsp;cust.screen<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcodpc&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'DPC',&nbsp;"Down&nbsp;Pay.&nbsp;Clear."DPC&nbsp;EhP4<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoitems_con&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'ITEMS_CON',&nbsp;&nbsp;&nbsp;"Contracts&nbsp;EhP5<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcoitems_tm&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'ITEMS_TM'.&nbsp;"TM&nbsp;EhP5e<br />
   </div>
   <div class="codeComment">
*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fcolicn(4)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;value&nbsp;'LICN'."&nbsp;Country&nbsp;INDIA(cin)<br />
<br />
<br />
   </div>
   <div class="code">
ENHANCEMENT-POINT LMR1MTOP_04 SPOTS ES_SAPLMR1M STATIC .<br />
<br />
CONSTANTS:<br />
   </div>
   <div class="codeComment">
*&nbsp;Sortierung&nbsp;Positionsdaten&nbsp;in&nbsp;Positionsliste<br />
   </div>
   <div class="code">
&nbsp;&nbsp;fco_so_matnr&nbsp;&nbsp;LIKE&nbsp;t066-fcode&nbsp;VALUE&nbsp;'SMAT',&nbsp;"&nbsp;Materialnummer<br />
&nbsp;&nbsp;fco_so_ean&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;t066-fcode&nbsp;VALUE&nbsp;'SEAN',&nbsp;"&nbsp;EAN<br />
&nbsp;&nbsp;fco_so_liefm&nbsp;&nbsp;LIKE&nbsp;t066-fcode&nbsp;VALUE&nbsp;'SLIM',&nbsp;"&nbsp;Lieferanten-Matnr<br />
&nbsp;&nbsp;fco_so_lfpos&nbsp;&nbsp;LIKE&nbsp;t066-fcode&nbsp;VALUE&nbsp;'SLPO',&nbsp;"&nbsp;Lieferpositionsnummer<br />
&nbsp;&nbsp;fco_so_bstpo&nbsp;&nbsp;LIKE&nbsp;t066-fcode&nbsp;VALUE&nbsp;'SBPO',&nbsp;"&nbsp;Bestellpositionsnummer<br />
&nbsp;&nbsp;fco_so_mwskz&nbsp;&nbsp;LIKE&nbsp;t066-fcode&nbsp;VALUE&nbsp;'SMWS',&nbsp;"&nbsp;Steuerkz<br />
<br />
   </div>
   <div class="codeComment">
*&nbsp;Aggregation<br />
   </div>
   <div class="code">
&nbsp;&nbsp;fco_icon&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;t066-fcode&nbsp;VALUE&nbsp;'ICON',&nbsp;&nbsp;"Positions&nbsp;in&nbsp;aggregation<br />
&nbsp;&nbsp;fco_select&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;t066-fcode&nbsp;VALUE&nbsp;'AGGR_SELECT',<br />
&nbsp;&nbsp;fco_deselect&nbsp;&nbsp;LIKE&nbsp;t066-fcode&nbsp;VALUE&nbsp;'AGGR_DESELECT',<br />
&nbsp;&nbsp;fco_select_undo&nbsp;LIKE&nbsp;t066-fcode&nbsp;VALUE&nbsp;'AGGR_UNDO',<br />
&nbsp;&nbsp;fco_expand&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;t066-fcode&nbsp;VALUE&nbsp;'AGGR_EXPAND',&nbsp;&nbsp;"VerdSt&nbsp;aufl#sen<br />
&nbsp;&nbsp;fco_collapse&nbsp;&nbsp;LIKE&nbsp;t066-fcode&nbsp;VALUE&nbsp;'AGGR_COLLAPSE',&nbsp;"verdichten<br />
&nbsp;&nbsp;fco_expand_all&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;t066-fcode&nbsp;VALUE&nbsp;'AGGR_EXPAND_ALL',<br />
&nbsp;&nbsp;fco_collapse_all&nbsp;&nbsp;LIKE&nbsp;t066-fcode&nbsp;VALUE&nbsp;'AGGR_COLLAPSE_ALL',<br />
&nbsp;&nbsp;fco_pos_back&nbsp;&nbsp;LIKE&nbsp;t066-fcode&nbsp;VALUE&nbsp;'AGGR_POSITIONS_BACK',<br />
&nbsp;&nbsp;fco_all_back&nbsp;&nbsp;LIKE&nbsp;t066-fcode&nbsp;VALUE&nbsp;'AGGR_ALL_BACK'.&nbsp;"Mark.&nbsp;rücksetzen<br />
<br />
   </div>
   <div class="codeComment">
*&nbsp;&nbsp;&nbsp;BEGIN&nbsp;New&nbsp;Empties,&nbsp;11.3.05&nbsp;-------------------------------<br />
   </div>
   <div class="code">
CONSTANTS: fco_nercdi LIKE t066-fcode VALUE 'NERCDI'.<br />
   </div>
   <div class="codeComment">
*&nbsp;&nbsp;&nbsp;END&nbsp;New&nbsp;Empties,&nbsp;11.3.05&nbsp;&nbsp;&nbsp;-------------------------------<br />
*&nbsp;Fcode&nbsp;for&nbsp;Reverse&nbsp;and&nbsp;Copy<br />
   </div>
   <div class="code">
CONSTANTS:<br />
&nbsp;&nbsp;fcochange_posted_invoice&nbsp;LIKE&nbsp;t066-fcode&nbsp;VALUE&nbsp;'COPY',<br />
&nbsp;&nbsp;fcodisregard_changes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;t066-fcode&nbsp;VALUE&nbsp;'DISREGARD'.<br />
   </div>
   <div class="codeComment">
*&nbsp;FCode&nbsp;for&nbsp;Core&nbsp;fields&nbsp;enhancement&nbsp;pop&nbsp;up&nbsp;window&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"NCF<br />
   </div>
   <div class="code">
CONSTANTS:<br />
&nbsp;&nbsp;fco_mmcorepop&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;t066-fcode&nbsp;VALUE&nbsp;'MM_CORE_POP'.<br />
CONSTANTS:                                        "TM Data Display<br />
&nbsp;&nbsp;fco_tm_data&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIKE&nbsp;ok-code&nbsp;VALUE&nbsp;'TM_DETAILS'.<br />
   </div>
   <div class="codeComment">
*eject<br />
*---------------------------------------------------------------------*<br />
*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Konstanten&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*<br />
*---------------------------------------------------------------------*<br />
<br />
   </div>
   <div class="code">
INCLUDE: mrm_const_common,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mrm_const_mrm,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mrm_const_me,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mrm_const_basis,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mrm_const_nast.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;message&nbsp;determination<br />
<br />
DATA: c_max_804 TYPE i VALUE 10.<br />
<br />
DATA: dyngr_ab LIKE sy-dyngr  VALUE 'AB  '.<br />
<br />
   </div>
   <div class="codeComment">
*eject<br />
*---------------------------------------------------------------------*<br />
*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Table&nbsp;Controls&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*<br />
*---------------------------------------------------------------------*<br />
   </div>
   <div class="code">
CONTROLS: tc_mr1m    TYPE TABLEVIEW USING SCREEN '6310',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tc_mr1m_co&nbsp;TYPE&nbsp;TABLEVIEW&nbsp;USING&nbsp;SCREEN&nbsp;'6410',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tc_mr1m_pb&nbsp;TYPE&nbsp;TABLEVIEW&nbsp;USING&nbsp;SCREEN&nbsp;'6250',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tc_mr1m_tx&nbsp;TYPE&nbsp;TABLEVIEW&nbsp;USING&nbsp;SCREEN&nbsp;'0804',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tc_mr1m_wt&nbsp;TYPE&nbsp;TABLEVIEW&nbsp;USING&nbsp;SCREEN&nbsp;'0921',&nbsp;"erweiterte&nbsp;QST<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tc_mr1m_ws&nbsp;TYPE&nbsp;TABLEVIEW&nbsp;USING&nbsp;SCREEN&nbsp;'0932',&nbsp;"Split&nbsp;Rbtr/QST<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tc_mr1m_vs&nbsp;TYPE&nbsp;TABLEVIEW&nbsp;USING&nbsp;SCREEN&nbsp;'0932',&nbsp;"Split&nbsp;Rebetr.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tc_msel_best&nbsp;&nbsp;TYPE&nbsp;TABLEVIEW&nbsp;USING&nbsp;SCREEN&nbsp;'6221',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tc_msel_best_spiin&nbsp;TYPE&nbsp;TABLEVIEW&nbsp;USING&nbsp;SCREEN&nbsp;'7221',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tc_msel_lifs&nbsp;&nbsp;TYPE&nbsp;TABLEVIEW&nbsp;USING&nbsp;SCREEN&nbsp;'6222',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tc_msel_frbr&nbsp;&nbsp;TYPE&nbsp;TABLEVIEW&nbsp;USING&nbsp;SCREEN&nbsp;'6223',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tc_msel_erfb&nbsp;&nbsp;TYPE&nbsp;TABLEVIEW&nbsp;USING&nbsp;SCREEN&nbsp;'6224',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tc_msel_werk&nbsp;&nbsp;TYPE&nbsp;TABLEVIEW&nbsp;USING&nbsp;SCREEN&nbsp;'6225',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tc_msel_zuord&nbsp;TYPE&nbsp;TABLEVIEW&nbsp;USING&nbsp;SCREEN&nbsp;'6225',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tc_msel_ven&nbsp;&nbsp;&nbsp;TYPE&nbsp;TABLEVIEW&nbsp;USING&nbsp;SCREEN&nbsp;'6226',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tc_msel_deli&nbsp;&nbsp;TYPE&nbsp;TABLEVIEW&nbsp;USING&nbsp;SCREEN&nbsp;'6227',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tc_msel_ven_dcfl&nbsp;&nbsp;&nbsp;TYPE&nbsp;TABLEVIEW&nbsp;USING&nbsp;SCREEN&nbsp;'6232',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tc_msel_deli_mr1m&nbsp;&nbsp;TYPE&nbsp;TABLEVIEW&nbsp;USING&nbsp;SCREEN&nbsp;'6229',&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"decoupling&nbsp;(DCFL)<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tc_msel_best_mr1m&nbsp;&nbsp;TYPE&nbsp;TABLEVIEW&nbsp;USING&nbsp;SCREEN&nbsp;'0550',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tc_msel_lifs_mr1m&nbsp;&nbsp;TYPE&nbsp;TABLEVIEW&nbsp;USING&nbsp;SCREEN&nbsp;'0551',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tc_msel_frbr_mr1m&nbsp;&nbsp;TYPE&nbsp;TABLEVIEW&nbsp;USING&nbsp;SCREEN&nbsp;'0552',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tc_msel_werk_mr1m&nbsp;&nbsp;TYPE&nbsp;TABLEVIEW&nbsp;USING&nbsp;SCREEN&nbsp;'0553',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tc_msel_erfb_mr1m&nbsp;&nbsp;TYPE&nbsp;TABLEVIEW&nbsp;USING&nbsp;SCREEN&nbsp;'0554',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tc_aggregation&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;TABLEVIEW&nbsp;USING&nbsp;SCREEN&nbsp;'6350',<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tc_curr&nbsp;TYPE&nbsp;TABLEVIEW&nbsp;USING&nbsp;SCREEN&nbsp;1250.<br />
CONTROLS: tc_msel_best_lin1 TYPE TABLEVIEW USING SCREEN '7241', "WP145920<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tc_msel_best_lin2&nbsp;TYPE&nbsp;TABLEVIEW&nbsp;USING&nbsp;SCREEN&nbsp;'7242',&nbsp;"WP145920<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tc_msel_co&nbsp;&nbsp;TYPE&nbsp;TABLEVIEW&nbsp;USING&nbsp;SCREEN&nbsp;'7251',&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"Contract&nbsp;EhP5<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tc_contract&nbsp;TYPE&nbsp;TABLEVIEW&nbsp;USING&nbsp;SCREEN&nbsp;'6320',&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"Contract&nbsp;EhP5<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tc_tm&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;TABLEVIEW&nbsp;USING&nbsp;SCREEN&nbsp;'6330'.&nbsp;&nbsp;&nbsp;"TM&nbsp;EhP5e<br />
ENHANCEMENT-POINT LMR1MTOP_05 SPOTS ES_SAPLMR1M STATIC .<br />
<br />
DATA: tc_mr1m_old_top_line LIKE tc_mr1m-top_line VALUE 1,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h_tc_msel_old_top_line&nbsp;TYPE&nbsp;sy-index.&nbsp;&nbsp;&nbsp;&nbsp;"ben#tigt&nbsp;für&nbsp;Dynpros<br />
"550 bis 554<br />
<br />
<br />
DATA: "gt_sel_contract TYPE STANDARD TABLE OF mrm_select_contract,         "Contract EhP5<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"gt_f4_contract&nbsp;TYPE&nbsp;STANDARD&nbsp;TABLE&nbsp;OF&nbsp;mrm_select_contract,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gs_tmp_contract&nbsp;TYPE&nbsp;mrm_select_contract,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gt_tmp_contract&nbsp;TYPE&nbsp;TABLE&nbsp;OF&nbsp;mrm_select_contract.<br />
<br />
DATA: BEGIN OF record,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ebeln&nbsp;TYPE&nbsp;ebeln,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ebelp&nbsp;TYPE&nbsp;ebelp,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;srm_ebeln&nbsp;TYPE&nbsp;ebeln,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;srm_ebelp&nbsp;TYPE&nbsp;srm_contract_item,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;txz01&nbsp;TYPE&nbsp;txz01,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;selkz(1),<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;END&nbsp;OF&nbsp;record.<br />
<br />
TYPES: BEGIN OF gs_srv_pckg_sty,                 "Contract EhP5<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;checkbox&nbsp;TYPE&nbsp;c,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;node_key&nbsp;TYPE&nbsp;lvc_nkey,"field&nbsp;for&nbsp;checkbox&nbsp;and&nbsp;node&nbsp;key<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;crdt_chk&nbsp;TYPE&nbsp;c.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;field&nbsp;for&nbsp;selection&nbsp;of&nbsp;servoce&nbsp;line&nbsp;in&nbsp;credit&nbsp;memo<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INCLUDE&nbsp;STRUCTURE&nbsp;mmsrv_srv_pkg_sty.<br />
TYPES: END OF gs_srv_pckg_sty.<br />
<br />
DATA : gt_outtab          TYPE TABLE OF  gs_srv_pckg_sty,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gt_srv_det&nbsp;TYPE&nbsp;srv_package_tab,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gt_gi_nodes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;treev_ntab,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;gi_nodes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;treev_ntab,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;g_srv_alv_tree&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;REF&nbsp;TO&nbsp;cl_gui_alv_tree,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;g_custom_container&nbsp;TYPE&nbsp;REF&nbsp;TO&nbsp;cl_gui_custom_container,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;g_flag&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;char1.&nbsp;&nbsp;&nbsp;&nbsp;"Contract&nbsp;EhP5<br />
<br />
   </div>
   <div class="codeComment">
*--------------------------------------------------------------------*<br />
*&nbsp;Predefinition&nbsp;of&nbsp;classes<br />
*--------------------------------------------------------------------*<br />
<br />
*&nbsp;Local&nbsp;classes&nbsp;for&nbsp;dwonpayment&nbsp;clearing<br />
   </div>
   <div class="code">
INCLUDE lmr1md01.                                           "DPC EhP4<br />
INCLUDE lmr1md02.                                           "TM EhP5<br />
INCLUDE lmr1md07.                                           "TM EhP5e<br />
INCLUDE lmr1md08.                                           "MAAe EhP5e<br />
INCLUDE lmr1md09.<br />
INCLUDE lmr1md10.<br />
INCLUDE lmr1md11.                                           "N1411439<br />
INCLUDE lmr1md12.                                           "EhP6 DInv<br />
INCLUDE lmr1md13.                                           "EhP6 DInv<br />
INCLUDE lmr1md14.                                           "EhP6 DInv<br />
INCLUDE lmr1md15.                                       "PO tree hist<br />
INCLUDE lmr1md03.                                      "Contract EhP5<br />
INCLUDE lmr1md04.                                      "Contract EhP5<br />
INCLUDE lmr1md06.                                      "Contract EhP5<br />
INCLUDE lmr1mp16.                                      "Contract EhP5<br />
<br />
   </div>
   <div class="codeComment">
*---------------------------------------------------------------------*<br />
*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tabstrip&nbsp;controls&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;enjoy&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*<br />
*---------------------------------------------------------------------*<br />
   </div>
   <div class="code">
CONTROLS: header TYPE TABSTRIP.<br />
CONTROLS: itemtab TYPE TABSTRIP.       " Prototyp Direktbuchen<br />
<br />
DATA: act_row        LIKE sy-tabix.    "1.Zeile Ausgabeseite<br />
<br />
   </div>
   <div class="codeComment">
*eject<br />
*---------------------------------------------------------------------*<br />
*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Macros&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*<br />
*---------------------------------------------------------------------*<br />
<br />
   </div>
   <div class="code">
INCLUDE: mrm_macro_common.<br />
<br />
   </div>
   <div class="codeComment">
*eject<br />
*---------------------------------------------------------------------*<br />
*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Feldsymbole&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*<br />
*---------------------------------------------------------------------*<br />
<br />
   </div>
   <div class="code">
FIELD-SYMBOLS: &lt;feld&gt;.                                    "#EC FD_ASSGN<br />
<br />
   </div>
   <div class="codeComment">
*eject<br />
*---------------------------------------------------------------------*<br />
*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Common&nbsp;Parts&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*<br />
*---------------------------------------------------------------------*<br />
<br />
   </div>
   <div class="code">
INCLUDE fm06ec08.<br />
INCLUDE fm06ecbe.<br />
INCLUDE vmsgpart.<br />
<br />
ENHANCEMENT-POINT lmr1mtop_01 SPOTS es_saplmr1m STATIC.<br />
<br />
   </div>
   <div class="codeComment">
*----------------------------------------------------------------------*<br />
*---&nbsp;LSA&nbsp;Begin&nbsp;Retrofit&nbsp;Brasilien&nbsp;-------------------------------------*<br />
*----------------------------------------------------------------------*<br />
*--------&nbsp;Tabelle&nbsp;für&nbsp;CUA-PF-Status&nbsp;(Ausnahmen)&nbsp;----------------------*<br />
   </div>
   <div class="code">
DATA:    BEGIN OF excl OCCURS 25,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;funktion(10),<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;END&nbsp;OF&nbsp;excl.<br />
<br />
<br />
   </div>
   <div class="codeComment">
*----------------------------------------------------------------------*<br />
*---&nbsp;LSA&nbsp;Begin&nbsp;Retrofit&nbsp;Brasilien&nbsp;-------------------------------------*<br />
*----------------------------------------------------------------------*<br />
<br />
<br />
*eject<br />
*----------------------------------------------------------------------*<br />
*&nbsp;&nbsp;&nbsp;&nbsp;Docking&nbsp;Control&nbsp;Tree&nbsp;Control&nbsp;Text&nbsp;Control&nbsp;Image&nbsp;Control&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*<br />
*----------------------------------------------------------------------*<br />
<br />
*-------&nbsp;Docking/Tree&nbsp;für&nbsp;Bestell-Historie&nbsp;----------------------------*<br />
<br />
   </div>
   <div class="code">
DATA: t_ebelntab TYPE TABLE OF ebelntab WITH HEADER LINE,  " PO's<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_text_icon(20)&nbsp;TYPE&nbsp;c,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;dynamic&nbsp;Tree-Button<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;dock_visible.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Tree&nbsp;On/Off<br />
<br />
INCLUDE lmr1mcl2.<br />
<br />
DATA: docking TYPE REF TO cl_gui_docking_container,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tree_obj&nbsp;TYPE&nbsp;REF&nbsp;TO&nbsp;cl_gui_column_tree,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tree_event_handler&nbsp;TYPE&nbsp;REF&nbsp;TO&nbsp;cl_tree_events,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t_tree_visu&nbsp;TYPE&nbsp;TABLE&nbsp;OF&nbsp;tree_visu&nbsp;WITH&nbsp;HEADER&nbsp;LINE.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Docking/Tree&nbsp;für&nbsp;Arbeitsvorrat/Vorerfassung&nbsp;------------------*<br />
   </div>
   <div class="code">
DATA: dock_v_visible,                  " Tree On/Off<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_text_icon_v(20)&nbsp;TYPE&nbsp;c,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;dynamic&nbsp;Tree-Button<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_treev_updated,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Steuerung&nbsp;Tree-Neuaufbau<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t_treev_visu&nbsp;TYPE&nbsp;TABLE&nbsp;OF&nbsp;treev_visu&nbsp;WITH&nbsp;HEADER&nbsp;LINE.<br />
<br />
   </div>
   <div class="codeComment">
*CLASS&nbsp;cl_treev_events&nbsp;DEFINITION&nbsp;DEFERRED.<br />
*INCLUDE&nbsp;lmr1mcl2.<br />
*CLASS&nbsp;cl_treev_events&nbsp;DEFINITION.<br />
*&nbsp;&nbsp;PUBLIC&nbsp;SECTION.<br />
*&nbsp;&nbsp;&nbsp;&nbsp;METHODS&nbsp;handle_item_double_click<br />
*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FOR&nbsp;EVENT&nbsp;item_double_click<br />
*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OF&nbsp;cl_gui_column_tree<br />
*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;IMPORTING&nbsp;node_key&nbsp;item_name.<br />
*ENDCLASS.<br />
<br />
   </div>
   <div class="code">
CLASS cl_gui_cfw DEFINITION LOAD.<br />
<br />
DATA: docking_v TYPE REF TO cl_gui_docking_container,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tree_v_obj&nbsp;TYPE&nbsp;REF&nbsp;TO&nbsp;cl_gui_column_tree,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;treev_event_handler&nbsp;TYPE&nbsp;REF&nbsp;TO&nbsp;cl_treev_events.<br />
<br />
DATA: t_nodes_expand TYPE treev_nks.<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Text&nbsp;Editor&nbsp;Control&nbsp;------------------------------------------*<br />
   </div>
   <div class="code">
DATA: editor TYPE REF TO c_textedit_control,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;container&nbsp;TYPE&nbsp;REF&nbsp;TO&nbsp;cl_gui_custom_container.<br />
CLASS cl_gui_cfw DEFINITION LOAD.<br />
DATA: edit_control_created.            " Edit Control an?<br />
<br />
   </div>
   <div class="codeComment">
*-------&nbsp;Image&nbsp;Control&nbsp;------------------------------------------------*<br />
   </div>
   <div class="code">
INCLUDE simagecontrolclassdef.<br />
INCLUDE simagecontrolclassimpl.<br />
<br />
DATA image_control TYPE REF TO c_image_control.<br />
DATA: image_control_created.           " Image Control an?<br />
<br />
   </div>
   <div class="codeComment">
*----------------------------------------------------------------------*<br />
*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Business&nbsp;Add&nbsp;In&nbsp;(BAdI)&nbsp;declarations<br />
*----------------------------------------------------------------------*<br />
<br />
*-----&nbsp;India&nbsp;version&nbsp;BAdi&nbsp;declarations&nbsp;--------------------------------*<br />
   </div>
   <div class="code">
TABLES: t005.<br />
CLASS cl_ex_mr_cin_lmr1mi2g DEFINITION LOAD.<br />
DATA: mr_grlivtax TYPE REF TO if_ex_mr_cin_lmr1mi2g.<br />
CLASS cl_ex_mr_cin_lmr1mi2g_sel DEFINITION LOAD.<br />
DATA: mr_livselkz TYPE REF TO if_ex_mr_cin_lmr1mi2g_sel.<br />
DATA: BEGIN OF j_1idrseg OCCURS 0.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INCLUDE&nbsp;STRUCTURE&nbsp;drseg.<br />
DATA: END OF j_1idrseg.<br />
DATA  old_selkz.<br />
DATA  not_empty.<br />
DATA  full.<br />
ENHANCEMENT-POINT lmr1mtop_02 SPOTS es_saplmr1m STATIC.<br />
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
