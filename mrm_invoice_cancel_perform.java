<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=GB2312" />
<title>MRM_INVOICE_CANCEL_PERFORM</title>
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
     <td><h2>Code listing for function MRM_INVOICE_CANCEL_PERFORM</h2>
<h3> Description: </h3></td>
   </tr>
  <tr>
     <td>
     <table class="innerTable">
       <tr>
          <td>
   <div class="code">
FUNCTION MRM_INVOICE_CANCEL_PERFORM.<br />
   </div>
   <div class="codeComment">
*"----------------------------------------------------------------------<br />
*"*"Lokale Schnittstelle:<br />
*"  IMPORTING<br />
*"     REFERENCE(I_RM08M) TYPE  RM08M<br />
*"     REFERENCE(I_T001W) TYPE  T001W<br />
*"     REFERENCE(I_EKKO) TYPE  EKKO<br />
*"     REFERENCE(I_VFKRED) TYPE  VF_KRED<br />
*"     REFERENCE(I_TRTYP) TYPE  TRTYP<br />
*"     REFERENCE(I_STORNO) TYPE  C DEFAULT SPACE<br />
*"     REFERENCE(I_BUDAT) TYPE  RBKP_V-BUDAT<br />
*"     REFERENCE(I_AKT_TYP) TYPE  T169-TRTYP<br />
*"     REFERENCE(I_STGRD) TYPE  STGRD<br />
*"     REFERENCE(I_BLDAT) TYPE  RBKP_V-BLDAT OPTIONAL<br />
*"  EXPORTING<br />
*"     REFERENCE(ST_RBKPV) TYPE  MRM_RBKPV<br />
*"  TABLES<br />
*"      T_BSET STRUCTURE  BSET<br />
*"      T_DRSEG TYPE  MMCR_TDRSEG<br />
*"      TAB_FRSEG TYPE  MMCR_TFRSEG<br />
*"      TAB_CO TYPE  MMCR_COBL_MRM<br />
*"      TAB_MA TYPE  MMCR_TMA<br />
*"  CHANGING<br />
*"     REFERENCE(RBKPV) TYPE  MRM_RBKPV<br />
*"     REFERENCE(ST_BELNR) TYPE  RBKP-BELNR<br />
*"     REFERENCE(OKCODE) TYPE  C<br />
*"     REFERENCE(XNEGP) TYPE  C<br />
*"----------------------------------------------------------------------<br />
<br />

<div class="codeComment">*       <a href ="global-mrm_invoice_cancel_perform.html">Global data declarations</a></div><br />
   </div>
   <div class="code">
&nbsp;&nbsp;DATA:&nbsp;f_budat&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;budat,&nbsp;&nbsp;"&nbsp;posting&nbsp;date<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;save_budat&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;budat.&nbsp;&nbsp;"&nbsp;posting&nbsp;date<br />
<br />
&nbsp;&nbsp;DATA:&nbsp;f_bldat&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;bldat,&nbsp;&nbsp;"&nbsp;document&nbsp;date<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;save_bldat&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TYPE&nbsp;bldat.&nbsp;&nbsp;"&nbsp;document&nbsp;date<br />
<br />
ENHANCEMENT-POINT MRM_INVOICE_CANCEL_PERFORM_01 SPOTS ES_SAPLMR1M.<br />
<br />
<br />
&nbsp;&nbsp;CALL&nbsp;FUNCTION&nbsp;'J_1B_NF_INVOICE'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_rbkp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;rbkpv<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_rm08m&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;i_rm08m<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_t001w&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;i_t001w<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_ekko&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;i_ekko<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_lifnr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;i_vfkred-lifnr<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_land1&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;i_vfkred-land1<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_regio&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;i_vfkred-regio<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_trtyp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;i_trtyp<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_okcode&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;okcode<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_storno&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;'X'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TABLES<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t_rseg&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;t_drseg<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t_bset&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;t_bset<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXCEPTIONS<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;not_localized&nbsp;&nbsp;&nbsp;=&nbsp;1<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;standard_change&nbsp;=&nbsp;2<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OTHERS&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;3.<br />
<br />
&nbsp;&nbsp;CALL&nbsp;FUNCTION&nbsp;'J_1B_NF_IV_CANCEL_REFERENCE'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_rbkpv&nbsp;&nbsp;&nbsp;=&nbsp;rbkpv<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXCEPTIONS<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;no_cancel&nbsp;=&nbsp;1<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OTHERS&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;2.<br />
<br />
ENHANCEMENT-POINT MRM_INVOICE_CANCEL_PERFORM_02 SPOTS ES_SAPLMR1M.<br />
   </div>
   <div class="codeComment">
*------ Wurde die Originalrechnung durch ERS erstellt?         ------*<br />
   </div>
   <div class="code">
&nbsp;&nbsp;IF&nbsp;rbkpv-ivtyp&nbsp;EQ&nbsp;c_ivtyp_ers&nbsp;OR&nbsp;rbkpv-ivtyp&nbsp;EQ&nbsp;c_ivtyp_ersnull.<br />
&nbsp;&nbsp;&nbsp;&nbsp;CLEAR:&nbsp;sy-msgid,&nbsp;sy-msgty,&nbsp;sy-msgno,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;sy-msgv1,&nbsp;sy-msgv2,&nbsp;sy-msgv3,&nbsp;sy-msgv4.<br />
<br />
&nbsp;&nbsp;&nbsp;&nbsp;CALL&nbsp;FUNCTION&nbsp;'CUSTOMIZED_MESSAGE'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_arbgb&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;'M8'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_dtype&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;'E'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_msgnr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;'414'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_var01&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;rbkpv-belnr<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_var02&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;rbkpv-gjahr<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXCEPTIONS<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;error_message&nbsp;=&nbsp;01.<br />
&nbsp;&nbsp;&nbsp;&nbsp;IF&nbsp;sy-subrc&nbsp;=&nbsp;1.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;sy-msgty&nbsp;=&nbsp;'E'.<br />
&nbsp;&nbsp;&nbsp;&nbsp;ENDIF.<br />
&nbsp;&nbsp;&nbsp;&nbsp;IF&nbsp;sy-msgty&nbsp;NE&nbsp;space.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MESSAGE&nbsp;ID&nbsp;'M8'&nbsp;TYPE&nbsp;sy-msgty&nbsp;NUMBER&nbsp;'414'<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;WITH&nbsp;rbkpv-belnr&nbsp;rbkpv-gjahr.<br />
&nbsp;&nbsp;&nbsp;&nbsp;ENDIF.<br />
&nbsp;&nbsp;ENDIF.<br />
ENHANCEMENT-POINT EHP604_MRM_INVOICE_CANCEL_P_01 SPOTS ES_SAPLMR1M.<br />
<br />
   </div>
   <div class="codeComment">
* Take document date from original document if not supplied<br />
   </div>
   <div class="code">
&nbsp;&nbsp;IF&nbsp;i_bldat&nbsp;IS&nbsp;INITIAL.<br />
&nbsp;&nbsp;&nbsp;&nbsp;f_bldat&nbsp;=&nbsp;rbkpv-bldat.<br />
&nbsp;&nbsp;ELSE.<br />
&nbsp;&nbsp;&nbsp;&nbsp;f_bldat&nbsp;=&nbsp;i_bldat.<br />
&nbsp;&nbsp;ENDIF.<br />
<br />
&nbsp;&nbsp;MOVE:&nbsp;rbkpv-bldat&nbsp;TO&nbsp;save_bldat,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_bldat&nbsp;TO&nbsp;rbkpv-bldat.<br />
<br />
   </div>
   <div class="codeComment">
*------ Buchungsdatum aus Originalbeleg, falls nicht eingegeben ------*<br />
   </div>
   <div class="code">
&nbsp;&nbsp;IF&nbsp;i_budat&nbsp;IS&nbsp;INITIAL.<br />
&nbsp;&nbsp;&nbsp;&nbsp;f_budat&nbsp;=&nbsp;rbkpv-budat.<br />
&nbsp;&nbsp;ELSE.<br />
&nbsp;&nbsp;&nbsp;&nbsp;f_budat&nbsp;=&nbsp;i_budat.<br />
&nbsp;&nbsp;ENDIF.<br />
<br />
   </div>
   <div class="codeComment">
*------ DRSEG mit Bestelldaten erweitern -----------------------------*<br />
   </div>
   <div class="code">
&nbsp;&nbsp;MOVE:&nbsp;rbkpv-budat&nbsp;TO&nbsp;save_budat,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rbkpv-budat&nbsp;TO&nbsp;rbkpv-wwert,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f_budat&nbsp;TO&nbsp;rbkpv-budat,<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;c_ivtyp_storno&nbsp;TO&nbsp;rbkpv-ivtyp.&nbsp;"1009320<br />
&nbsp;&nbsp;PERFORM&nbsp;drseg_complete&nbsp;USING&nbsp;&nbsp;&nbsp;&nbsp;rbkpv<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_akt_typ<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_stgrd<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CHANGING&nbsp;t_drseg[].<br />
<br />
&nbsp;&nbsp;MOVE:&nbsp;save_budat&nbsp;TO&nbsp;rbkpv-budat.<br />
<br />
ENHANCEMENT-SECTION     EHP604_MRM_INVOICE_CANEL_PERF1 SPOTS ES_SAPLMR1M.<br />
&nbsp;&nbsp;CALL&nbsp;FUNCTION&nbsp;'MRM_INVOICE_CANCEL_CONVERT'<br />
<br />
<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EXPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_rbkpv&nbsp;=&nbsp;rbkpv<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_budat&nbsp;=&nbsp;f_budat<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i_stgrd&nbsp;=&nbsp;i_stgrd<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;IMPORTING<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;e_rbkpv&nbsp;=&nbsp;st_rbkpv<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;e_xnegp&nbsp;=&nbsp;xnegp<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TABLES<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t_drseg&nbsp;=&nbsp;t_drseg&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Exporting<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t_frseg&nbsp;=&nbsp;tab_frseg&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Importing<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t_co&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;tab_co&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Importing<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;t_ma&nbsp;&nbsp;&nbsp;&nbsp;=&nbsp;tab_ma.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"&nbsp;Importing<br />
END-ENHANCEMENT-SECTION.<br />
<br />
&nbsp;&nbsp;CLEAR:&nbsp;st_belnr.<br />
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
