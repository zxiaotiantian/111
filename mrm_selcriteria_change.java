<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=GB2312" />
<title>MRM_SELCRITERIA_CHANGE</title>
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
     <td><h2>Code listing for function MRM_SELCRITERIA_CHANGE</h2>
<h3> Description: </h3></td>
   </tr>
  <tr>
     <td>
     <table class="innerTable">
       <tr>
          <td>
   <div class="code">
FUNCTION MRM_SELCRITERIA_CHANGE.<br />
   </div>
   <div class="codeComment">
*"----------------------------------------------------------------------<br />
*"*"Lokale Schnittstelle:<br />
*"  IMPORTING<br />
*"     VALUE(I_RBKPV) TYPE  MRM_RBKPV<br />
*"     VALUE(I_FCODE) DEFAULT '    '<br />
*"     VALUE(I_TRTYP) LIKE  T169-TRTYP DEFAULT 'A'<br />
*"  EXPORTING<br />
*"     VALUE(E_FCODE)<br />
*"  TABLES<br />
*"      T_RBSELBEST STRUCTURE  RBSELBEST OPTIONAL<br />
*"      T_RBSELFRBR STRUCTURE  RBSELFRBR OPTIONAL<br />
*"      T_RBSELLIFS STRUCTURE  RBSELLIFS OPTIONAL<br />
*"      T_RBSELWERK STRUCTURE  RBSELWERK OPTIONAL<br />
*"      T_RBSELERFB STRUCTURE  RBSELERFB OPTIONAL<br />
*"      T_RBSELTRAN STRUCTURE  LETRA_IV_FIELDS OPTIONAL<br />
*"----------------------------------------------------------------------<br />
<br />

<div class="codeComment">*       <a href ="global-mrm_selcriteria_change.html">Global data declarations</a></div><br />
   </div>
   <div class="code">
&nbsp;&nbsp;CLEAR:&nbsp;MRMPO,&nbsp;RM08M.<br />
<br />
&nbsp;&nbsp;REFRESH:&nbsp;XMSEL_BEST,&nbsp;XMSEL_FRBR,&nbsp;XMSEL_LIFS,&nbsp;XMSEL_WERK.<br />
<br />
&nbsp;&nbsp;MOVE:&nbsp;I_FCODE&nbsp;TO&nbsp;OK-CODE,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;I_TRTYP&nbsp;TO&nbsp;AKT_TYP.<br />
&nbsp;&nbsp;CLEAR&nbsp;OK-CODE_500.<br />
   </div>
   <div class="codeComment">
*     falls Einstieg aus der Batch-#bersicht erfolgt<br />
   </div>
   <div class="code">
&nbsp;&nbsp;MRMPO-XSAVED&nbsp;=&nbsp;X.<br />
&nbsp;&nbsp;MRMPO-XBATCH&nbsp;=&nbsp;'U'.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;aus&nbsp;Uebersicht,&nbsp;wichtig&nbsp;fuer&nbsp;Zuordnung<br />
&nbsp;&nbsp;MRMPO-XSELREAD&nbsp;=&nbsp;SPACE.<br />
&nbsp;&nbsp;MRMPO-XZUOCHG&nbsp;&nbsp;=&nbsp;SPACE.<br />
&nbsp;&nbsp;MOVE-CORRESPONDING&nbsp;I_RBKPV&nbsp;TO&nbsp;RM08M.<br />
&nbsp;&nbsp;MOVE-CORRESPONDING&nbsp;I_RBKPV&nbsp;TO&nbsp;RBKPV.<br />
&nbsp;&nbsp;RBKP-ERFPR&nbsp;=&nbsp;RBKPV-ERFPR.<br />
<br />
   </div>
   <div class="codeComment">
*----- Erfassungsprofil ermitteln, falls vorhanden -------------------*<br />
   </div>
   <div class="code">
&nbsp;&nbsp;IF&nbsp;RBKPV-ERFPR&nbsp;NE&nbsp;SPACE.<br />
&nbsp;&nbsp;&nbsp;&nbsp;CALL&nbsp;FUNCTION&nbsp;'MRM_T169H_SINGLE_READ'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;I_ERFPR&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;RBKPV-ERFPR<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;IMPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;E_T169H&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;H_T169H<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXCEPTIONS<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ENTRY_NOT_FOUND&nbsp;=&nbsp;1<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OTHERS&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;2.<br />
&nbsp;&nbsp;ENDIF.<br />
<br />
&nbsp;&nbsp;PERFORM&nbsp;ZUORDNUNGSKRITERIEN_LESEN.<br />
&nbsp;&nbsp;PERFORM&nbsp;ZUORDNUNGSKRIT_AUFBEREITEN.<br />
<br />
&nbsp;&nbsp;PERFORM&nbsp;CALL_DYNPRO&nbsp;USING&nbsp;'0500'.<br />
<br />
&nbsp;&nbsp;IF&nbsp;OK-CODE_500&nbsp;=&nbsp;FCOOK.<br />
   </div>
   <div class="codeComment">
*------- Sichern der Zuordnungskriterien in internen Tabellen<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;PERFORM&nbsp;SICHERN_KRITERIEN.<br />
   </div>
   <div class="codeComment">
*------- Fehlerprotokoll speichern<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;PERFORM&nbsp;PROTOKOLL_SPEICHERN&nbsp;using&nbsp;'X'.<br />
&nbsp;&nbsp;&nbsp;&nbsp;MESSAGE&nbsp;I508.<br />
   </div>
   <div class="codeComment">
*   Es erfolgt keine automatische Zuordnung nach #nderung der Kriterien<br />
   </div>
   <div class="code">
&nbsp;&nbsp;ENDIF.<br />
&nbsp;&nbsp;E_FCODE&nbsp;=&nbsp;OK-CODE.<br />
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
