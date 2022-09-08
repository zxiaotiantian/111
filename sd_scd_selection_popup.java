<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=GB2312" />
<title>SD_SCD_SELECTION_POPUP</title>
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
     <td><h2>Code listing for function SD_SCD_SELECTION_POPUP</h2>
<h3> Description: </h3></td>
   </tr>
  <tr>
     <td>
     <table class="innerTable">
       <tr>
          <td>
   <div class="code">
FUNCTION SD_SCD_SELECTION_POPUP.<br />
   </div>
   <div class="codeComment">
*"----------------------------------------------------------------------<br />
*"*"Lokale Schnittstelle:<br />
*"  IMPORTING<br />
*"     REFERENCE(BUKRS)<br />
*"----------------------------------------------------------------------<br />
<br />

<div class="codeComment">*       <a href ="global-sd_scd_selection_popup.html">Global data declarations</a></div><br />
   </div>
   <div class="code">
types: begin of vfkp_entry,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;refty&nbsp;like&nbsp;vfkp-refty,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rebel&nbsp;like&nbsp;vfkp-rebel,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;repos&nbsp;like&nbsp;vfkp-repos,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fknum&nbsp;like&nbsp;vfkp-fknum,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fkpos&nbsp;like&nbsp;vfkp-fkpos,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;lblni&nbsp;like&nbsp;vfkp-lblni,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tdlnr&nbsp;like&nbsp;vfkp-tdlnr,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rechs&nbsp;like&nbsp;vfkp-rechs,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;end&nbsp;of&nbsp;vfkp_entry.<br />
<br />
types: vfkp_entries type vfkp_entry occurs 0.<br />
<br />
data: vfkp_entries_tab type vfkp_entries.<br />
<br />
data: vfkp_entry_wa type vfkp_entry.<br />
<br />
<br />
<br />
clear vfkp_entry_wa.<br />
refresh vfkp_entries_tab.<br />
export vfkp_entries_tab to memory id 'vfkp_entries_inv_verif'.<br />
<br />
<br />
<br />
   </div>
   <div class="codeComment">
* #bergabe an den Report ZRV54FRSL zur Frachtkostenselektion -----------<br />
**submit ZRV54FRSL<br />
*<br />
*         with p_rechs = 'VF-1'<br />
*         with p_kred  = 'VF-1'<br />
*         with p_bukrs = '0001'<br />
*<br />
*        and return.<br />
*<br />
<br />
   </div>
   <div class="code">
&nbsp;&nbsp;IMPORT&nbsp;vfkp_entries_tab&nbsp;FROM&nbsp;MEMORY&nbsp;ID&nbsp;'VFKP_ENTRIES_INV_VERIF'.<br />
&nbsp;&nbsp;CLEAR&nbsp;xeksel.&nbsp;REFRESH&nbsp;xeksel.<br />
<br />
&nbsp;&nbsp;LOOP&nbsp;AT&nbsp;vfkp_entries_tab&nbsp;INTO&nbsp;vfkp_entry_wa.<br />
<br />
&nbsp;&nbsp;&nbsp;&nbsp;CALL&nbsp;FUNCTION&nbsp;'ME_SELECT_DOCUMENTS'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_lblni&nbsp;=&nbsp;vfkp_entry_wa-lblni<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_lifnr&nbsp;=&nbsp;vfkp_entry_wa-tdlnr<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TABLES<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t_eksel&nbsp;=&nbsp;xeksel<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXCEPTIONS<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OTHERS&nbsp;&nbsp;=&nbsp;0.<br />
<br />
&nbsp;&nbsp;&nbsp;&nbsp;READ&nbsp;TABLE&nbsp;xeksel&nbsp;INDEX&nbsp;1.<br />
&nbsp;&nbsp;&nbsp;&nbsp;IF&nbsp;sy-subrc&nbsp;=&nbsp;0.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;xek08r_flag&nbsp;=&nbsp;1.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CLEAR:&nbsp;rm08r-lfbnr,&nbsp;rm08r-lfpos.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rm08r-ebeln&nbsp;=&nbsp;'*'.<br />
&nbsp;&nbsp;&nbsp;&nbsp;ELSE.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SET&nbsp;CURSOR&nbsp;FIELD&nbsp;'RM08R-LFBNR'.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MESSAGE&nbsp;e030&nbsp;WITH&nbsp;rm08r-lfbnr&nbsp;rm08r-gjahr.<br />
&nbsp;&nbsp;&nbsp;&nbsp;ENDIF.<br />
<br />
&nbsp;&nbsp;ENDLOOP.<br />
<br />
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
