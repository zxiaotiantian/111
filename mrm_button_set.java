<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=GB2312" />
<title>MRM_BUTTON_SET</title>
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
     <td><h2>Code listing for function MRM_BUTTON_SET</h2>
<h3> Description: </h3></td>
   </tr>
  <tr>
     <td>
     <table class="innerTable">
       <tr>
          <td>
   <div class="code">
FUNCTION MRM_BUTTON_SET.<br />
   </div>
   <div class="codeComment">
*"----------------------------------------------------------------------<br />
*"*"Lokale Schnittstelle:<br />
*"       IMPORTING<br />
*"             VALUE(I_VERSION) TYPE  C<br />
*"       EXPORTING<br />
*"             VALUE(E_DYNPFIELD) TYPE  ICONS-TEXT<br />
*"       EXCEPTIONS<br />
*"              INVALID_SCREEN_VERSION<br />
*"----------------------------------------------------------------------<br />
<br />

<div class="codeComment">*       <a href ="global-mrm_button_set.html">Global data declarations</a></div><br />
   </div>
   <div class="code">
&nbsp;&nbsp;DATA:&nbsp;ICONNAME&nbsp;LIKE&nbsp;ICON-NAME,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ICONINFO&nbsp;LIKE&nbsp;ICONT-QUICKINFO.<br />
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
&nbsp;&nbsp;CASE&nbsp;I_VERSION.<br />
&nbsp;&nbsp;&nbsp;&nbsp;WHEN&nbsp;0.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"small&nbsp;subscreen<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ICONNAME&nbsp;=&nbsp;'ICON_EXPAND_ALL'.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ICONINFO&nbsp;=&nbsp;TEXT-050.<br />
&nbsp;&nbsp;&nbsp;&nbsp;WHEN&nbsp;1.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"large&nbsp;subscreen<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ICONNAME&nbsp;=&nbsp;'ICON_COLLAPSE_ALL'.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ICONINFO&nbsp;=&nbsp;TEXT-050.<br />
&nbsp;&nbsp;&nbsp;&nbsp;WHEN&nbsp;OTHERS.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;RAISE&nbsp;INVALID_SCREEN_VERSION.&nbsp;&nbsp;&nbsp;"&nbsp;darf&nbsp;nicht&nbsp;sein&nbsp;--&gt;&nbsp;Abbruch<br />
&nbsp;&nbsp;ENDCASE.<br />
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
   </div>
   <div class="codeComment">
*           info   = iconinfo<br />
   </div>
   <div class="code">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;IMPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;RESULT&nbsp;=&nbsp;E_DYNPFIELD<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXCEPTIONS<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OTHERS&nbsp;=&nbsp;1.<br />
&nbsp;&nbsp;IF&nbsp;(&nbsp;SY-SUBRC&nbsp;&lt;&gt;&nbsp;0&nbsp;).<br />
&nbsp;&nbsp;&nbsp;&nbsp;MESSAGE&nbsp;E547&nbsp;WITH&nbsp;'MRM_BUTTON_SET'.<br />
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
