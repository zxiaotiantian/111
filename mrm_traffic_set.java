<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=GB2312" />
<title>MRM_TRAFFIC_SET</title>
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
     <td><h2>Code listing for function MRM_TRAFFIC_SET</h2>
<h3> Description: </h3></td>
   </tr>
  <tr>
     <td>
     <table class="innerTable">
       <tr>
          <td>
   <div class="code">
FUNCTION MRM_TRAFFIC_SET.<br />
   </div>
   <div class="codeComment">
*"----------------------------------------------------------------------<br />
*"*"Lokale Schnittstelle:<br />
*"       IMPORTING<br />
*"             VALUE(I_XCORRECT) TYPE  C<br />
*"             VALUE(I_XUNCLEAR) TYPE  C<br />
*"       EXPORTING<br />
*"             VALUE(E_DYNPFIELD) LIKE  ICON-NAME<br />
*"       TABLES<br />
*"              T_DRSEG TYPE  MMCR_TDRSEG OPTIONAL<br />
*"              T_DRSEGR TYPE  MMCR_TDRSEG OPTIONAL<br />
*"----------------------------------------------------------------------<br />
<br />
<br />

<div class="codeComment">*       <a href ="global-mrm_traffic_set.html">Global data declarations</a></div><br />
   </div>
   <div class="code">
&nbsp;&nbsp;DATA:&nbsp;ICONNAME&nbsp;LIKE&nbsp;ICON-NAME,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ICONINFO&nbsp;LIKE&nbsp;ICONT-QUICKINFO.<br />
<br />
<br />
   </div>
   <div class="codeComment">
*  Iconnamen und Quicktext bestimmen<br />
<br />
   </div>
   <div class="code">
&nbsp;&nbsp;CLEAR:&nbsp;ICONNAME,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ICONINFO.<br />
<br />
&nbsp;&nbsp;IF&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(&nbsp;I_XCORRECT&nbsp;=&nbsp;SPACE&nbsp;).<br />
   </div>
   <div class="codeComment">
*   Re nicht korrekt -&gt; Rot<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;ICONNAME&nbsp;=&nbsp;'ICON_RED_LIGHT'.<br />
&nbsp;&nbsp;&nbsp;&nbsp;ICONINFO&nbsp;=&nbsp;TEXT-050.<br />
<br />
&nbsp;&nbsp;ELSEIF&nbsp;(&nbsp;I_XUNCLEAR&nbsp;=&nbsp;X&nbsp;).<br />
   </div>
   <div class="codeComment">
*   Re enth#lt ungekl#rte Fehler -&gt; Gelb<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;ICONNAME&nbsp;=&nbsp;'ICON_YELLOW_LIGHT'.<br />
&nbsp;&nbsp;&nbsp;&nbsp;ICONINFO&nbsp;=&nbsp;TEXT-051.<br />
<br />
&nbsp;&nbsp;ELSE.&nbsp;"Re&nbsp;enth#lt&nbsp;keine&nbsp;ungekl#rte&nbsp;Fehler&nbsp;-&gt;&nbsp;prüfe,&nbsp;ob&nbsp;Re&nbsp;gesperrt<br />
ENHANCEMENT-SECTION     MRM_TRAFFIC_SET_01 SPOTS ES_SAPLMR1M.<br />
&nbsp;&nbsp;&nbsp;&nbsp;IF&nbsp;(&nbsp;T_DRSEG&nbsp;IS&nbsp;REQUESTED&nbsp;).&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"Tabelle&nbsp;wurde&nbsp;angegeben<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LOOP&nbsp;AT&nbsp;T_DRSEG&nbsp;WHERE&nbsp;(&nbsp;SELKZ&nbsp;&lt;&gt;&nbsp;SPACE&nbsp;)<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;AND&nbsp;(&nbsp;(&nbsp;SPGRP&nbsp;&lt;&gt;&nbsp;SPACE&nbsp;)&nbsp;OR<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(&nbsp;SPGRM&nbsp;&lt;&gt;&nbsp;SPACE&nbsp;)&nbsp;OR<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(&nbsp;SPGRG&nbsp;&lt;&gt;&nbsp;SPACE&nbsp;)&nbsp;OR<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(&nbsp;SPGRQ&nbsp;&lt;&gt;&nbsp;SPACE&nbsp;)&nbsp;OR<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(&nbsp;SPGRT&nbsp;&lt;&gt;&nbsp;SPACE&nbsp;)&nbsp;OR<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(&nbsp;SPGRS&nbsp;&lt;&gt;&nbsp;SPACE&nbsp;)&nbsp;OR<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(&nbsp;SPGRC&nbsp;&lt;&gt;&nbsp;SPACE&nbsp;)&nbsp;).<br />
   </div>
   <div class="codeComment">
*     Re enth#lt (sichtbare) gesperrte Positionen -&gt; Gelb<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ICONNAME&nbsp;=&nbsp;'ICON_YELLOW_LIGHT'.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ICONINFO&nbsp;=&nbsp;TEXT-052.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXIT.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"------&gt;<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ENDLOOP.<br />
&nbsp;&nbsp;&nbsp;&nbsp;ENDIF.<br />
<br />
&nbsp;&nbsp;&nbsp;&nbsp;IF&nbsp;(&nbsp;ICONNAME&nbsp;IS&nbsp;INITIAL&nbsp;&nbsp;&nbsp;)&nbsp;AND<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(&nbsp;T_DRSEGR&nbsp;IS&nbsp;REQUESTED&nbsp;).&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"Tabelle&nbsp;wurde&nbsp;angegeben<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LOOP&nbsp;AT&nbsp;T_DRSEGR&nbsp;WHERE&nbsp;(&nbsp;SELKZ&nbsp;&lt;&gt;&nbsp;SPACE&nbsp;)<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;AND&nbsp;(&nbsp;(&nbsp;SPGRP&nbsp;&lt;&gt;&nbsp;SPACE&nbsp;)&nbsp;OR<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(&nbsp;SPGRM&nbsp;&lt;&gt;&nbsp;SPACE&nbsp;)&nbsp;OR<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(&nbsp;SPGRG&nbsp;&lt;&gt;&nbsp;SPACE&nbsp;)&nbsp;OR<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(&nbsp;SPGRQ&nbsp;&lt;&gt;&nbsp;SPACE&nbsp;)&nbsp;OR<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(&nbsp;SPGRT&nbsp;&lt;&gt;&nbsp;SPACE&nbsp;)&nbsp;OR<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(&nbsp;SPGRS&nbsp;&lt;&gt;&nbsp;SPACE&nbsp;)&nbsp;OR<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(&nbsp;SPGRC&nbsp;&lt;&gt;&nbsp;SPACE&nbsp;)&nbsp;).<br />
   </div>
   <div class="codeComment">
*       Re enth#lt (unsichtbare) gesperrte Positionen -&gt; Gelb<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ICONNAME&nbsp;=&nbsp;'ICON_YELLOW_LIGHT'.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ICONINFO&nbsp;=&nbsp;TEXT-053.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXIT.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"------&gt;<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ENDLOOP.<br />
&nbsp;&nbsp;&nbsp;&nbsp;ENDIF.<br />
END-ENHANCEMENT-SECTION.<br />
&nbsp;&nbsp;&nbsp;&nbsp;IF&nbsp;(&nbsp;ICONNAME&nbsp;IS&nbsp;INITIAL&nbsp;).<br />
   </div>
   <div class="codeComment">
*     Re ist korrekt und sollte auch gebucht werden -&gt; Grün<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ICONNAME&nbsp;=&nbsp;'ICON_GREEN_LIGHT'.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ICONINFO&nbsp;=&nbsp;TEXT-054.<br />
&nbsp;&nbsp;&nbsp;&nbsp;ENDIF.<br />
&nbsp;&nbsp;ENDIF.<br />
<br />
<br />
   </div>
   <div class="codeComment">
**** Feld E_DYNPFIELD füllen mit "Icon-Codierung"<br />
   </div>
   <div class="code">
&nbsp;&nbsp;MOVE&nbsp;SPACE&nbsp;TO&nbsp;ICONINFO+22(8).&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"L#nge&nbsp;22&nbsp;nicht&nbsp;überschreiten!<br />
<br />
&nbsp;&nbsp;CALL&nbsp;FUNCTION&nbsp;'ICON_CREATE'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;NAME&nbsp;&nbsp;&nbsp;=&nbsp;ICONNAME<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INFO&nbsp;&nbsp;&nbsp;=&nbsp;ICONINFO<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;IMPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;RESULT&nbsp;=&nbsp;E_DYNPFIELD<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXCEPTIONS<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OTHERS&nbsp;=&nbsp;1.<br />
&nbsp;&nbsp;IF&nbsp;(&nbsp;SY-SUBRC&nbsp;&lt;&gt;&nbsp;0&nbsp;).<br />
&nbsp;&nbsp;&nbsp;&nbsp;MESSAGE&nbsp;E547&nbsp;WITH&nbsp;'MRM_TRAFFIC_SET'.<br />
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
