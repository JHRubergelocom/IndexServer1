/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexserver1;

import byps.RemoteException;
import de.elo.ix.client.AccessC;
import de.elo.ix.client.AclItem;
import de.elo.ix.client.AclItemC;
import de.elo.ix.client.ArcPath;
import de.elo.ix.client.ArchivingModeC;
import de.elo.ix.client.CheckinUsersC;
import de.elo.ix.client.CheckoutUsersC;
import de.elo.ix.client.ClientInfo;
import de.elo.ix.client.ColorData;
import de.elo.ix.client.CombineAclResult;
import de.elo.ix.client.ContextTerm;
import de.elo.ix.client.CopyInfo;
import de.elo.ix.client.CopyOptions;
import de.elo.ix.client.CopySordC;
import de.elo.ix.client.CountResult;
import de.elo.ix.client.CounterInfo;
import de.elo.ix.client.CryptInfo;
import de.elo.ix.client.DeleteOptions;
import de.elo.ix.client.DocMask;
import de.elo.ix.client.DocMaskC;
import de.elo.ix.client.DocMaskLine;
import de.elo.ix.client.DocMaskLineC;
import de.elo.ix.client.DocVersion;
import de.elo.ix.client.Document;
import de.elo.ix.client.EditInfo;
import de.elo.ix.client.EditInfoC;
import de.elo.ix.client.EditInfoZ;
import de.elo.ix.client.FileData;
import de.elo.ix.client.FindByAcl;
import de.elo.ix.client.FindByFulltext;
import de.elo.ix.client.FindByFulltextResultItem;
import de.elo.ix.client.FindByIndex;
import de.elo.ix.client.FindByNotes;
import de.elo.ix.client.FindByPreviewCtrl;
import de.elo.ix.client.FindBySordHist;
import de.elo.ix.client.FindByType;
import de.elo.ix.client.FindByVersion;
import de.elo.ix.client.FindInfo;
import de.elo.ix.client.FindChildren;
import de.elo.ix.client.FindDirect;
import de.elo.ix.client.FindOptions;
import de.elo.ix.client.FindResult;
import de.elo.ix.client.FindTasksInfo;
import de.elo.ix.client.FindWorkflowInfo;
import de.elo.ix.client.FontInfo;
import de.elo.ix.client.IXConnFactory;
import de.elo.ix.client.IXConnection;
import de.elo.ix.client.IXExceptionC;
import de.elo.ix.client.IXProperties;
import de.elo.ix.client.IdName;
import de.elo.ix.client.JobState;
import de.elo.ix.client.KeyValue;
import de.elo.ix.client.Keyword;
import de.elo.ix.client.KeywordC;
import de.elo.ix.client.KeywordsDynamicInfo;
import de.elo.ix.client.LockC;
import de.elo.ix.client.MaskName;
import de.elo.ix.client.NavigationInfo;
import de.elo.ix.client.Note;
import de.elo.ix.client.NoteC;
import de.elo.ix.client.NoteFreehandC;
import de.elo.ix.client.NoteImage;
import de.elo.ix.client.NoteTemplate;
import de.elo.ix.client.NoteTemplateC;
import de.elo.ix.client.NoteText;
import de.elo.ix.client.ObjKey;
import de.elo.ix.client.PointInfo;
import de.elo.ix.client.ProcessAcl;
import de.elo.ix.client.ProcessCopyElements;
import de.elo.ix.client.ProcessCountElements;
import de.elo.ix.client.ProcessInfo;
import de.elo.ix.client.ProcessMoveDocumentsToStoragePath;
import de.elo.ix.client.Reminder;
import de.elo.ix.client.SearchModeC;
import de.elo.ix.client.SearchTermsC;
import de.elo.ix.client.SessionOptions;
import de.elo.ix.client.SessionOptionsC;
import de.elo.ix.client.Sord;
import de.elo.ix.client.SordC;
import de.elo.ix.client.SordHist;
import de.elo.ix.client.SordHistKey;
import de.elo.ix.client.SordHistKeyC;
import de.elo.ix.client.SordLink;
import de.elo.ix.client.SordType;
import de.elo.ix.client.SordTypeC;
import de.elo.ix.client.SordZ;
import de.elo.ix.client.SortOrderC;
import de.elo.ix.client.UserInfo;
import de.elo.ix.client.UserInfoC;
import de.elo.ix.client.UserTask;
import de.elo.ix.client.UserTaskPriorityC;
import de.elo.ix.client.WFCollectNode;
import de.elo.ix.client.WFDelegateNodeInfo;
import de.elo.ix.client.WFDiagram;
import de.elo.ix.client.WFDiagramC;
import de.elo.ix.client.WFNode;
import de.elo.ix.client.WFNodeAssoc;
import de.elo.ix.client.WFNodeC;
import de.elo.ix.client.WFNodeMatrix;
import de.elo.ix.client.WFTypeC;
import de.elo.ix.client.WFVersion;
import de.elo.ix.client.WorkflowExportOptions;
import de.elo.ix.client.feed.Action;
import de.elo.ix.client.feed.ActionC;
import de.elo.ix.client.feed.EActionType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import javafx.scene.paint.Color;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author ruberg
 */
public class IndexServer1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LoginInfo();
        ShowConfigApp("contract");
        ShowUnittestsApp();
        ShowDynKwl();

        Tutorial();
        AnmeldungAmIndexserver();
        DokumenteVersionenAttachmentsSignaturenPreviews();
        OrdnerUndDokumentTypen();
        Verschlagwortung();
        BerechtigungenAclItems();
        SucheNachOrdnernUndDokumenten();
        EbenenUndDokumenttypenSordTypes();
        RandnotizenAnmerkungenStempelUndSchwaerzungen();
        Workflows();
        Wiedervorlage();
        JavaScript();
        AnwenderOrdner();
        FeedService();        
    }
    
    static void LoginInfo()  {
        IXConnFactory connFact = new IXConnFactory("http://playground.dev.elo/ix-Solutions/ix", "IX-Tutorial", "1.0");
        IXConnection conn = (IXConnection)new Object();
        try {
            conn = connFact.create("Administrator", "elo", "localhost", null);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        System.out.println("ticket=" + conn.getLoginResult().getClientInfo().getTicket());
        System.out.println("IX-Url=" + conn.getEndpointUrl());
    }

    public static void OpenUrl(String url) {
        if(java.awt.Desktop.isDesktopSupported() ) {
        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
        java.net.URI uri;
        try {
            if(desktop.isSupported(java.awt.Desktop.Action.BROWSE) ) {
              uri = new java.net.URI(url);
                try {
                    desktop.browse(uri);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }            
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        } 
      }         
    }

    static Map<String, String> GetConfigApp(String solution) {
        IXConnFactory connFact = new IXConnFactory("http://playground.dev.elo/ix-Solutions/ix", "GetConfigApp("+ solution + ")", "1.0");
        IXConnection ixConn = (IXConnection) new Object();
        try {
            ixConn = connFact.create("Administrator", "elo", "localhost", null);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        String parentId = "ARCPATH[(E10E1000-E100-E100-E100-E10E10E10E00)]:/Business Solutions/" + solution + "/ELOapps/ClientInfos";
        Sord[] sordELOappsClientInfo = FindChildren(parentId, ixConn);
        String configApp = "";
        String configId = "";
        String configGuid = "";
        Map<String, String> dicApp = new HashMap<>();
        for (Sord s : sordELOappsClientInfo) {
            String jsonString = DownloadDocumentToString(s, ixConn);
            jsonString = jsonString.replaceAll("namespace", "namespace1");            
            JSONObject config;    
            try {
                config = new JSONObject(jsonString);
                JSONObject selector = config.getJSONObject("selector");                 
                JSONObject web = config.getJSONObject("web");                 
                String arcPath = selector.getString("arcPath");
                if (arcPath != null) {
                    if (arcPath.contains(solution + ".config")) {
                        configApp = web.getString("namespace1") + "." + web.getString("id");
                        configId = config.getString("id");
                        configGuid = ixConn.ix().checkoutSord(arcPath, SordC.mbAll, LockC.NO).getGuid();

                    }
                }
            } catch (JSONException | RemoteException ex) {
                ex.printStackTrace();
            }
        }
        dicApp.put("configApp", configApp);
        dicApp.put("configId", configId);
        dicApp.put("configGuid", configGuid);                
        return dicApp;
    }

    static void ShowConfigApp(String solution) {
        IXConnFactory connFact = new IXConnFactory("http://playground.dev.elo/ix-Solutions/ix", "IX-Tutorial", "1.0");
        IXConnection ixConn = (IXConnection) new Object();
        try {
            ixConn = connFact.create("Administrator", "elo", "localhost", null);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        String ticket = ixConn.getLoginResult().getClientInfo().getTicket();
        String ixUrl = ixConn.getEndpointUrl();
        String appUrl = ixUrl.replaceAll("ix-", "wf-");
        appUrl = appUrl.replaceAll("/ix", "/apps/app");
        appUrl = appUrl + "/";
        Map<String, String> dicApp = GetConfigApp(solution);
        appUrl = appUrl + dicApp.get("configApp");
        appUrl = appUrl + "/?lang=de";
        appUrl = appUrl + "/?lang=de";
        appUrl = appUrl + "&ciId=" + dicApp.get("configApp");
        appUrl = appUrl + "&ticket=" + ticket;
        appUrl = appUrl + "&guid=" + dicApp.get("configGuid");
        appUrl = appUrl + "&timezone=Europe%2FBerlin";
        OpenUrl(appUrl);
    }

    static Map<String, String> GetUnittestApp() {
        IXConnFactory connFact = new IXConnFactory("http://playground.dev.elo/ix-Solutions/ix", "GetUnittestApp()", "1.0");
        IXConnection ixConn = (IXConnection) new Object();
        try {
            ixConn = connFact.create("Administrator", "elo", "localhost", null);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        String parentId = "ARCPATH[(E10E1000-E100-E100-E100-E10E10E10E00)]:/Business Solutions/development/ELOapps/ClientInfos";
        Sord[] sordELOappsClientInfo = FindChildren(parentId, ixConn);
        String configApp = "";
        String configId = "";
        for (Sord s : sordELOappsClientInfo) {
            String jsonString = DownloadDocumentToString(s, ixConn);
            jsonString = jsonString.replaceAll("namespace", "namespace1");
            JSONObject config;    
            try {
                config = new JSONObject(jsonString);
                JSONObject web = config.getJSONObject("web");                 
                String webId = web.getString("id");
                if (webId != null) {
                    if (webId.contains("UnitTests")) {
                        configApp = web.getString("namespace1") + "." + web.getString("id");
                        configId = config.getString("id");
                    }
                }
            } catch (JSONException ex) {
                ex.printStackTrace();
            }
        }
        Map<String, String> dicApp = new HashMap<>();
        dicApp.put("configApp", configApp);
        dicApp.put("configId", configId);
        return dicApp;
    }

    static void ShowUnittestsApp() {
        IXConnFactory connFact = new IXConnFactory("http://playground.dev.elo/ix-Solutions/ix", "IX-Tutorial", "1.0");
        IXConnection ixConn = (IXConnection) new Object();
        try {
            ixConn = connFact.create("Administrator", "elo", "localhost", null);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        String ticket = ixConn.getLoginResult().getClientInfo().getTicket();
        String ixUrl = ixConn.getEndpointUrl();
        String appUrl = ixUrl.replaceAll("ix-", "wf-");
        appUrl = appUrl.replaceAll("/ix", "/apps/app");
        appUrl = appUrl + "/";
        Map<String, String> dicApp = GetUnittestApp();
        appUrl = appUrl + dicApp.get("configApp");
        appUrl = appUrl + "/?lang=de";
        appUrl = appUrl + "/?lang=de";
        appUrl = appUrl + "&ciId=" + dicApp.get("configApp");
        appUrl = appUrl + "&ticket=" + ticket;
        appUrl = appUrl + "&timezone=Europe%2FBerlin";
        OpenUrl(appUrl);
    }

    static void ShowDynKwl()  {
        IXConnFactory connFact = new IXConnFactory("http://playground.dev.elo/ix-Solutions/ix", "IX-Tutorial", "1.0");
        IXConnection ixConn = (IXConnection) new Object();
        try {
            ixConn = connFact.create("Administrator", "elo", "localhost", null);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        String objId = "ARCPATH[(E10E1000-E100-E100-E100-E10E10E10E00)]:/Business Solutions/visitor [unit tests]/Test data/Group";
        try {
            Sord sordCourse = ixConn.ix().checkoutSord(objId, SordC.mbAll, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        KeywordsDynamicInfo dynkwl = new KeywordsDynamicInfo();
    }  

    static Sord[] FindChildren (String objId, IXConnection ixConn) {
        System.out.println("FindChildren: objId " + objId + " ixConn " + ixConn);

        try {
            ixConn.ix().checkoutSord(objId, SordC.mbAll, LockC.NO);
        } catch (RemoteException e) {
            return new Sord[]{};
        }

        Sord[] children = new Sord[]{};
        FindInfo findInfo = new FindInfo();
        FindChildren findChildren = new FindChildren();
        FindByType findByType = new FindByType();
        FindByIndex findByIndex = new FindByIndex();
        Boolean includeReferences = false;
        SordZ sordZ = SordC.mbAll;
        Boolean recursive = false;
        int level = 3;
        ObjKey[] objKeys = new ObjKey[]{};
        findChildren.setParentId(objId);
        findChildren.setMainParent(!includeReferences);
        findChildren.setEndLevel((recursive) ? level : 1);
        findInfo.setFindChildren(findChildren);
        findInfo.setFindByIndex(findByIndex);

        FindResult findResult = new FindResult();
        try {
            int idx = 0;
            findResult = ixConn.ix().findFirstSords(findInfo, 1000, sordZ);
            while (true) {
                children = findResult.getSords();
                if (!findResult.isMoreResults()) {
                    break;
                }
                idx += findResult.getSords().length;
                findResult = ixConn.ix().findNextSords(findResult.getSearchId(), idx, 1000, sordZ);
                }
            } catch (RemoteException ex) {
                ex.printStackTrace();
            } finally {
                if (findResult != null) {
                    try {
                        ixConn.ix().findClose(findResult.getSearchId());
                    } catch (RemoteException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        return children;
    }

    static void Tutorial() {
        // Beispiel 1: Verbindungsaufbau, Login
        IXConnFactory connFact = new IXConnFactory("http://playground.dev.elo/ix-Solutions/ix", "IX-Tutorial", "1.0");
        IXConnection conn = (IXConnection) new Object();
        try {
            conn = connFact.create("Administrator", "elo", "localhost", null);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        System.out.println("ticket=" + conn.getLoginResult().getClientInfo().getTicket());

        // Beispiel 2: Dokument lesen
        String objId = "87450";
        EditInfo ed = new EditInfo();
        try {
            ed = conn.ix().checkoutDoc(objId, null, EditInfoC.mbDocument, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        DocVersion dv = ed.getDocument().getDocs()[0];
        // String outFile = System.IO.Path.GetTempFileName() + "." + dv.getExt();
        File outFile = new File("TempFile");        
        try {
            outFile = File.createTempFile("test", "." + dv.getExt());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            conn.download(dv.getUrl(), outFile);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        outFile.deleteOnExit();

        //Beispiel 3: Archivpfad, Indexwert und GUID als Zugriffskennung
        //objId = "ARCPATH:/Buchhaltung/Rechnungen/2010/Hotelbuchung-11/12";
        //objId = "OKEY:INVOICE=4711";
        //objId = "(81737EC2-A845-ED5A-3EC9-AC3745A9A447)";

        //Beispiel 4: Verschlagwortung lesen
        objId = "12039";
        try {
            ed = conn.ix().checkoutSord(objId, EditInfoC.mbSord, LockC.NO);
        } catch (RemoteException ex) {
                ex.printStackTrace();
        }
        Sord sord = ed.getSord();
        System.out.println("id=" + sord.getId());
        System.out.println("guid=" + sord.getGuid());
        System.out.println("name=" + sord.getName());
        System.out.println("memo=" + sord.getDesc());
        System.out.println("IDate=" + sord.getIDateIso());
        System.out.println("XDate=" + sord.getXDateIso());
        ObjKey[] objKeys = sord.getObjKeys();
        for (int i = 0; i < objKeys.length; i++) {
            ObjKey okey = objKeys[i];
            System.out.println("okey[" + i + "]:");
            System.out.println(" id=" + okey.getId());
            System.out.println(" name=" + okey.getName());
            String[] data = okey.getData();
            for (int di = 0; di < data.length; di++) {
                System.out.println(" data[" + di + "]=" + data[di]);
            }
        }

        // Beispiel 5: Dokument einfügen
        String parentId = ed.getSord().getId() + "";
        String file = "E:\\Temp\\Test2.png";

        try {
            // Step 1
            ed = conn.ix().createDoc(parentId, "", null, EditInfoC.mbSordDocAtt);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        sord = ed.getSord();
        sord.setName("Test2");

        // Step 2 
        Document doc = new Document();
        doc.setDocs(new DocVersion[] { new DocVersion() });
        doc.getDocs()[0].setPathId(sord.getPath());
        doc.getDocs()[0].setEncryptionSet(sord.getDetails().getEncryptionSet());
        doc.getDocs()[0].setExt(conn.getFileExt(file));
        try {
            doc = conn.ix().checkinDocBegin(doc);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        try {
            // Step 3
            doc.getDocs()[0].setUploadResult(conn.upload(doc.getDocs()[0].getUrl(), new File(file)));
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        try {
            // Step 4
            doc = conn.ix().checkinDocEnd(sord, SordC.mbAll, doc, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        System.out.println("Object-ID=" + doc.getObjId() + ", Document-ID=" + doc.getDocs()[0].getId());

        // Beispiel 6: Dokumente suchen
        FindInfo fi = new FindInfo();
        FindByIndex fx = new FindByIndex();
        fi.setFindByIndex(fx);

        ObjKey[] okeys = new ObjKey[] { new ObjKey(), new ObjKey() };
        okeys[0].setName("ELOOUTL1");
        okeys[0].setData(new String[] { "fritz*" });
        okeys[1].setName("ELOOUTL2");
        okeys[1].setData(new String[] { "maria*" });

        fx.setObjKeys(okeys);
        fx.setMaskId("E-Mail");

        FindResult fr = null;

        try {
            int idx = 0;
            SordZ sordZ = new SordZ(SordC.mbName | SordC.mbObjKeys | SordC.mbDocVersion);
            fr = conn.ix().findFirstSords(fi, 1000, SordC.mbAll);
            while (true) {
                for (Sord sord1 : fr.getSords()) {
                    System.out.println("-- name=" + sord1.getName() + " –-");
                    System.out.println("from=" + sord1.getObjKeys()[0].getData()[0]);
                    System.out.println("to=" + sord1.getObjKeys()[1].getData()[0]);
                    if (sord1.getDocVersion() != null) {
                        System.out.println("url=" + sord1.getDocVersion().getUrl());
                    }
                }

                if (!fr.isMoreResults()) break;

                idx += fr.getSords().length;
                fr = conn.ix().findNextSords(fr.getSearchId(), idx, 1000, sordZ);
            }
        }
        catch (RemoteException ex) {
            ex.printStackTrace();
        }
        finally
        {
            if (fr != null)
            {
                try {
                    conn.ix().findClose(fr.getSearchId());
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

    static void AnmeldungAmIndexserver() {

        // Beispiel 8: Einfache Initialisierung eines IXConnFactory Objekts
        /*
        String url = "http://server:port/ix-archive/ix"; 
        String appName = "Tutorial Application"; 
        String appVersion = "1.0"; 
        IXConnFactory connFact = new IXConnFactory(url, appName, appVersion);
        */
        
        // Beispiel 9: Ausführliche Initialisierung eines IXConnFactory Objekts
        // ----------- Connection properties 
        String url = "http://server:port/ix-archive/ix"; 
        int nbOfConnections = 10; // ignored in .NET programs 
        int timeoutSeconds = 600; 
        IXProperties connProps = (IXProperties)IXConnFactory.createConnProps(url, nbOfConnections, timeoutSeconds);

        // --------------- Session options 
        String appName = "Tutorial Application"; 
        String appVersion = "1.0"; 
        IXProperties sessOpts = (IXProperties)IXConnFactory.createSessionOptions(appName, appVersion);

        // Application type is initialized 
        // and should not be modified without consultation: 
        // sessOpts[SessionOptionsC.CLIENT_APP_TYPE] = 
        // SessionOptionsC.TYPE_PARTNER_APPLICATION; 

        // Encrypted documents: Indexserver has to encrypt/decrypt 
        sessOpts.setProperty(SessionOptionsC.ENCRYPT_DOCUMENTS, "true"); 
        sessOpts.setProperty(SessionOptionsC.DECRYPT_DOCUMENTS, "true"); 

        // Translate storage mask names, index values etc. 
        sessOpts.setProperty(SessionOptionsC.TRANSLATE_TERMS, "true"); 

        // Indexserver returns ISO date values with separators (ISO 8601) 
        sessOpts.setProperty(SessionOptionsC.ISO_DATE_WITH_DELIMS, "true"); 

        // Wildcards for database queries 
        sessOpts.setProperty(SessionOptionsC.DB_WILDCARDS, "*?");

        // ---------------- Create connection factory 
        // IXConnFactory connFact = new IXConnFactory(connProps, sessOpts);

        // Beispiel 10: Session-Options nachträglich ändern 
        IXConnFactory connFact = new IXConnFactory("http://srvpdevbs01vm:8030/ix-common/ix", "AnmeldungAmIndexserver", "1.0");
        IXConnection conn = (IXConnection) new Object();
        try {
            conn = connFact.create("NormalerUser", "elo", "localhost", null);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Create test folder 
        Sord sord = new Sord(); 
        try {
            sord = conn.ix().createSord("1", "", EditInfoC.mbSord).getSord();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        sord.setName("Tutorial-test"); 
        try { 
            sord.setId(conn.ix().checkinSord(sord, SordC.mbAll, LockC.NO));
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        try {
            // Print filing date, standard format does not use delimiters:
            // IsoDate=20100324102600
            sord = conn.ix().checkoutSord(Integer.toString( sord.getId()), EditInfoC.mbSordLean, LockC.NO).getSord();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        System.out.println("IsoDate=" + sord.getIDateIso());

        // Set option for formatting ISO dates with delimiters 
        sessOpts = conn.getSessionOptions(); 
        sessOpts.setProperty(SessionOptionsC.ISO_DATE_WITH_DELIMS, "true"); 

        KeyValue[] kvs = new KeyValue[sessOpts.size()];
        int index = 0;
        for(Object key : sessOpts.keySet()) {
            kvs[index].setKey(key.toString());
            kvs[index].setValue(sessOpts.get(key).toString());
            index++;            
        }
        
        // SessionOptions opts = IXSessionOptions.makeSessOptsObj(sessOpts); 
        SessionOptions opts = new SessionOptions();
        opts.setOptions(kvs);
        
        try {
            // Print filing date, formatted with delimiters:
            // IsoDate=2010-03-24 10:26:00
            sord = conn.ix().checkoutSord(Integer.toString(sord.getId()), EditInfoC.mbSordLean, LockC.NO).getSord();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        System.out.println("IsoDate=" + sord.getIDateIso());

        // Beispiel 11: Anmeldung mit Name und Kennwort
        Map<String, String> env = System.getenv();
        
        String computerName = "TUTORIAL-" + getComputerName();
        // conn = connFact.create("NormalerUser", "elo", computerName, null);


        // Beispiel 14: Verwendung eines fremden Tickets

        // Initialize a ClientInfo object that contains the 
        // language, country of the client program and the UTC timezone. 
        ClientInfo ci = connFact.makeDefaultClientInfo();

        // set the ticket 
        IXConnFactory connFact1 = new IXConnFactory("http://srvpdevbs01vm:8030/ix-common/ix", "Other Session", "1.0");
        IXConnection conn1 = (IXConnection) new Object();
        try {
            conn1 = connFact1.create("NormalerUser", "elo", "localhost", null);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        ci.setTicket(conn1.getLoginResult().getClientInfo().getTicket());

        try {
            // create a session that uses the given ticket IXConnection
            conn = connFact.createFromTicket(ci);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // set session options if nessesary, e.g.: 
        sessOpts = conn.getSessionOptions(); 
        sessOpts.setProperty(SessionOptionsC.TRANSLATE_TERMS, "true"); 

        kvs = new KeyValue[sessOpts.size()];
        index = 0;
        for(Object key : sessOpts.keySet()) {
            kvs[index].setKey(key.toString());
            kvs[index].setValue(sessOpts.get(key).toString());
            index++;            
        }        
        // opts = IXSessionOptions.makeSessOptsObj(sessOpts); 
        opts = new SessionOptions();
        opts.setOptions(kvs);
        
        try {
            conn.ix().setSessionOptions(opts);
            
            // Beispiel 15: Session Abmelden
            // conn1.close();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

    }

    static void DokumenteVersionenAttachmentsSignaturenPreviews() {
        // Beispiel 16: Dokumentversion, hinzufügen
        IXConnFactory connFact = new IXConnFactory("http://srvpdevbs01vm:8030/ix-common/ix", "DokumenteVersionenAttachmentsSignaturenPreviews", "1.0");
        IXConnection conn = (IXConnection) new Object();
        try {
            conn = connFact.create("Administrator", "ELObs!dev", "localhost", null);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        String objId = "92403";
        String file = "E:\\Temp\\Test2.png";

        // Step 1 
        EditInfo ed = new EditInfo();
        try {
            ed = conn.ix().checkoutDoc(objId, null, EditInfoC.mbDocument,LockC.IF_FREE);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        Document doc = ed.getDocument();

        try {
            // Step 2
            doc = conn.ix().checkinDocBegin(doc);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        try {
            // Step 3
            doc.getDocs()[0].setUploadResult(conn.upload(doc.getDocs()[0].getUrl(), new File( file)));
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        try {
            // Step 4
            doc = conn.ix().checkinDocEnd(null, null, doc, LockC.YES);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        System.out.println("Object-ID=" + doc.getObjId() + ", Document-ID=" + doc.getDocs()[0].getId());

        // Beispiel 17: Dokumentversion hinzufügen und Verschlagwortungsinformationen ändern
        String fileName = "E:\\Temp\\Test2.png";
        int pathId = 1;

        try {
            // Step 1
            ed = conn.ix().checkoutDoc(objId, null, EditInfoC.mbSordDoc, LockC.IF_FREE);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        ed.getSord().setName(ed.getSord().getName() + "-1"); 
        ed.getSord().setPath(pathId); 
        SetOriginalFileName(ed.getSord(), fileName);

        // Step 2 
        doc = ed.getDocument(); 
        doc.getDocs()[0].setExt(conn.getFileExt(file)); 
        doc.getDocs()[0].setPathId(ed.getSord().getPath());
        doc.getDocs()[0].setEncryptionSet(ed.getSord().getDetails().getEncryptionSet()); 
        try {
            doc = conn.ix().checkinDocBegin(doc);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        try {
            // Step 3
            doc.getDocs()[0].setUploadResult(conn.upload(doc.getDocs()[0].getUrl(), new File(fileName)));
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        try {
            // Step 4
            doc = conn.ix().checkinDocEnd(ed.getSord(), SordC.mbAll, doc, LockC.YES);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        System.out.println("Object-ID=" + doc.getObjId() + ", Document-ID=" + doc.getDocs()[0].getId());

        //Beispiel 19: Sperren und Freigeben von Dokumenten
        int objId1 = 92403;

        try {
            // lock
            conn.ix().checkoutSord(Integer.toString(objId1), EditInfoC.mbOnlyId, LockC.IF_FREE);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // unlock 
        Sord sord = new Sord(); 
        sord.setId(objId1); 
        try {
            conn.ix().checkinSord(sord, SordC.mbOnlyId, LockC.YES);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Beispiel 20: Mehrere Dokumente einchecken
        String parentId = ed.getSord().getId() + "";
        String maskId = "0";
        String[] docFiles =new String[]{"E:\\Temp\\Test31.png", "E:\\Temp\\Test32.png","E:\\Temp\\Test33.png"};

        // (1) 
        Sord[] sords = new Sord[docFiles.length]; 
        Document[] documents = new Document[docFiles.length]; 
        for (int i = 0; i < sords.length; i++) { 
            try { 
                ed = conn.ix().createDoc(parentId, maskId, null, EditInfoC.mbSord);
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
            sord = sords[i] = ed.getSord(); 
            sord.setName("My document " + i); 

            doc = documents[i] = new Document(); 
            DocVersion dv = new DocVersion(); 
            dv.setPathId(sord.getPath()); 
            dv.setEncryptionSet(sord.getDetails().getEncryptionSet()); 
            dv.setExt(conn.getFileExt(docFiles[i])); 
            doc.setDocs(new DocVersion[] {dv}); 
        }

        try {
            // (2)
            documents = conn.ix().checkinDocsBegin(documents);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // (3) 
        for (int i = 0; i < documents.length; i++) { 
            DocVersion dv = documents[i].getDocs()[0]; 
            try { 
                dv.setUploadResult(conn.upload(dv.getUrl(), new File( docFiles[i])));
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }

        // (4)
        SordZ[] sordZs = new SordZ[] { SordC.mbAll }; 
        try { 
            documents = conn.ix().checkinDocsEnd(sords, sordZs, documents, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        for (Document document : documents) {
            System.out.println("objId=" + document.getObjId()); 
        }

        // Beispiel 21: Mehrere Dokumentversionen einchecken
        parentId = ed.getSord().getId() + "";
        maskId = "0";
        docFiles = new String[] { "E:\\Temp\\Test31.png", "E:\\Temp\\Test32.png", "E:\\Temp\\Test33.png" };

        try { 
            ed = conn.ix().createDoc(parentId, maskId, null, EditInfoC.mbSordDoc);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        sord = ed.getSord(); 
        sord.setName("My document"); 

        doc = new Document(); 
        doc.setDocs(new DocVersion[docFiles.length]); 

        for (int i = 0; i < doc.getDocs().length; i++) { 
            DocVersion dv = doc.getDocs()[i] = new DocVersion(); 
            dv.setWorkVersion((i == 0)); 
            dv.setPathId(sord.getPath()); 
            dv.setEncryptionSet(sord.getDetails().getEncryptionSet()); 
            dv.setExt(conn.getFileExt(docFiles[i])); 
        }

        try { 
            doc = conn.ix().checkinDocBegin(doc);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < doc.getDocs().length; i++) { 
            DocVersion dv = doc.getDocs()[i]; 
            try {
                dv.setUploadResult(conn.upload(dv.getUrl(),new File(docFiles[i])));
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }

        try { 
            doc = conn.ix().checkinDocEnd(sord, SordC.mbAll, doc, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        System.out.println("objId=" + doc.getObjId());

        // Beispiel 22: Alle Dokumentversionen auflisten
        objId = "91532";

        long editC = EditInfoC.mbDocumentMembers | EditInfoC.mbAttachmentMembers; 
        EditInfoZ editZ = new EditInfoZ(editC, new SordZ()); 
        try { 
            ed = conn.ix().checkoutDoc(objId, "-1", editZ, LockC.FORCE);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        System.out.println("document versions:"); 
        DumpDocVersions(ed.getDocument().getDocs()); 
        System.out.println("attachment versions:"); 
        DumpDocVersions(ed.getDocument().getAtts());

        //Beispiel 23: Attachment einchecken
        objId = "91532";
        file = "E:\\Temp\\Anlage1.txt";

        try {
            // Step 1
            ed = conn.ix().checkoutDoc(objId, null, EditInfoC.mbSordDocAtt, LockC.FORCE);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        doc = ed.getDocument();

        // Step 2 
        doc.setAtts(new DocVersion[] { new DocVersion() });
        doc.getAtts()[0].setPathId(doc.getDocs()[0].getPathId());
        doc.getAtts()[0].setExt(conn.getFileExt(file));
        try {
            doc = conn.ix().checkinDocBegin(doc);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        try {
            // Step 3
            doc.getAtts()[0].setUploadResult(conn.upload(doc.getAtts()[0].getUrl(),new File(file)));
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        try {
            // Step 4
            doc = conn.ix().checkinDocEnd(null, null, doc, LockC.YES);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        System.out.println("Object-ID=" + doc.getObjId() + ", Attachment-ID=" + doc.getAtts()[0].getId());

        //Beispiel 24: Signatur nachträglich hinzufügen
        objId ="91532";
        String sigFile = "E:\\Temp\\Signatur1.txt";

        try {
            ed = conn.ix().checkoutDoc(objId, null, EditInfoC.mbDocument, LockC.FORCE);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        doc = ed.getDocument();

        int docId = doc.getDocs()[0].getId(); // memorize document version ID 

        doc.getDocs()[0].setSig(new DocVersion());
        doc.getDocs()[0].getSig().setPathId(doc.getDocs()[0].getPathId());
        doc.getDocs()[0].getSig().setExt(conn.getFileExt(sigFile));

        try {
            doc = conn.ix().checkinDocBegin(doc); // version ID get lost 
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        try {
            doc.getDocs()[0].getSig().setUploadResult(conn.upload(doc.getDocs()[0].getSig().getUrl(),new File(sigFile)));
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        doc.setObjId(objId);
        doc.getDocs()[0].setId(docId); // reset document version ID 
        try {
            conn.ix().checkinDocEnd(null, null, doc, LockC.YES);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Beispiel 25: Signatur lesen            
        objId = "91532";
        sigFile = "E:\\Temp\\Signatur2.txt";

        try { 
            ed = conn.ix().checkoutDoc(objId, null, EditInfoC.mbDocument, LockC.FORCE);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        doc = ed.getDocument(); 
        if (doc.getDocs()[0].getSig() != null) {
            try {
                conn.download(doc.getDocs()[0].getSig().getUrl(),new File(sigFile)); 
            }
            catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        // Beispiel 26: Preview nachträglich hinzufügen            
        objId ="91532";
        String previewFile = "E:\\Temp\\Smile.png";

        try {
            ed = conn.ix().checkoutDoc(objId, null, EditInfoC.mbDocument, LockC.YES);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        doc = ed.getDocument(); 
        docId = doc.getDocs()[0].getId(); // memorize document version ID 

        doc.getDocs()[0].setPreview(new DocVersion()); 
        doc.getDocs()[0].getPreview().setExt(conn.getFileExt(previewFile)); 

        try {
            doc = conn.ix().checkinDocBegin(doc); // version ID get lost 
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        try { 
            doc.getDocs()[0].getPreview().setUploadResult(conn.upload( doc.getDocs()[0].getPreview().getUrl(),new File(previewFile)));
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Beispiel 29: Fehler bei der Preview-Erstellung melden
        // doc.getDocs()[0].getPreview().setUploadResult() = DocVersionC.UPLOAD_RESULT_ERROR;

        doc.getDocs()[0].setId(docId); // reset document version ID 
        try {
            conn.ix().checkinDocEnd(null, null, doc, LockC.YES);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        //Beispiel 27: Preview lesen
        objId ="91532";
        previewFile = "E:\\Temp\\Preview.png";

        try { 
            ed = conn.ix().checkoutDoc(objId, null, EditInfoC.mbDocument, LockC.YES);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        doc = ed.getDocument(); 
        if (doc.getDocs()[0].getPreview() != null) {
            try {
                conn.download(doc.getDocs()[0].getPreview().getUrl(),new File(previewFile)); 
            }
            catch (RemoteException e){
                e.printStackTrace();
            }
        }

        // Beispiel 28: Suche nach Dokumenten ohne Preview
        FindInfo fi = new FindInfo(); 
        fi.setFindByPreviewCtrl(new FindByPreviewCtrl()); 
        fi.getFindByPreviewCtrl().setPreviewAvailable(false); 
        fi.getFindByPreviewCtrl().setPreviewError(false);     

        // Beispiel 30: Kombiniertes Schreiben von Versionen, Attachments usw.
        parentId = ed.getSord().getId() + "";
        maskId = "0"; 
        docFiles = new String[]{"E:\\Temp\\Test31.png", "E:\\Temp\\Test32.png","E:\\Temp\\Test33.png"};
        String[] sigFiles = new String[] { "E:\\Temp\\Signatur31.txt", "E:\\Temp\\Signatur32.txt", "E:\\Temp\\Signatur33.txt"};
        String[] previewFiles = new String[] { "E:\\Temp\\Preview31.png", "E:\\Temp\\Preview32.png", "E:\\Temp\\Preview33.png" };
        String[] attFiles = new String[] { "E:\\Temp\\Att31.txt", "E:\\Temp\\Att32.txt", "E:\\Temp\\Att33.txt" };

        try { 
            ed = conn.ix().createDoc(parentId, maskId, null, EditInfoC.mbSordDoc);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        sord = ed.getSord();
        sord.setName("My document1");

        doc = new Document();
        doc.setDocs(new DocVersion[docFiles.length]); 
        doc.setAtts( new DocVersion[attFiles.length]);

        // prepare DocVersion objects for versions and previews 
        for (int i = 0; i < doc.getDocs().length; i++) { 
            DocVersion dv = doc.getDocs()[i] = new DocVersion(); 
            dv.setPathId(sord.getPath()); 
            dv.setEncryptionSet(sord.getDetails().getEncryptionSet()); 
            dv.setExt(conn.getFileExt(docFiles[i])); 

            dv.setSig(new DocVersion()); 
            dv.getSig().setPathId(sord.getPath()); 
            dv.getSig().setExt(conn.getFileExt(sigFiles[i])); 

            if (sord.getDetails().getEncryptionSet() == 0) { 
                dv.setPreview(new DocVersion()); 
                dv.getPreview().setPathId(sord.getPath()); 
                dv.getPreview().setExt(conn.getFileExt(previewFiles[i])); 
            } 
        }

        // prepare DocVersion objects for attachments 
        for (int i = 0; i < doc.getAtts().length; i++) { 
            DocVersion dv = doc.getAtts()[i] = new DocVersion(); 
            dv.setPathId(sord.getPath()); 
            dv.setExt(conn.getFileExt(attFiles[i]));
        }

        try {
            // call checkinDocBegin to obtain URLs
            doc = conn.ix().checkinDocBegin(doc);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // upload versions and previews 
        for (int i = 0; i < doc.getDocs().length; i++) { 
            DocVersion dv = doc.getDocs()[i]; 
            try { 
                dv.setUploadResult(conn.upload(dv.getUrl(),new File(docFiles[i])));
                dv.getSig().setUploadResult(conn.upload(dv.getSig().getUrl(),new File(sigFiles[i]))); 
                if (dv.getPreview() != null) { 
                    dv.getPreview().setUploadResult(conn.upload(dv.getPreview().getUrl(),new File(previewFiles[i]))); 
                } 
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }

        // upload attachment versions 
        for (int i = 0; i < doc.getAtts().length; i++) { 
            DocVersion dv = doc.getAtts()[i]; 
            try { 
                dv.setUploadResult(conn.upload(dv.getUrl(),new File(attFiles[i])));
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }

        try {
            // finish checkin
            doc = conn.ix().checkinDocEnd(sord, SordC.mbAll, doc, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        System.out.println("objId=" + doc.getObjId());

        // Beispiel 31: Volltextinhalt hinzufügen
        objId = "92212";
        String fulltextFile = "E:\\Temp\\Volltext.txt";

        try { 
            ed = conn.ix().checkoutDoc(objId, null, EditInfoC.mbDocument, LockC.YES);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        doc = ed.getDocument(); 
        docId = doc.getDocs()[0].getId(); // memorize document version ID 

        doc.getDocs()[0].setFulltextContent(new DocVersion()); 
        doc.getDocs()[0].getFulltextContent().setExt(conn.getFileExt(fulltextFile)); 
        try {
            doc = conn.ix().checkinDocBegin(doc); // version ID get lost 
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        try { 
            doc.getDocs()[0].getFulltextContent().setUploadResult(conn.upload( doc.getDocs()[0].getFulltextContent().getUrl(),new File(fulltextFile)));
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        doc.getDocs()[0].setId(docId); // reset document version ID 
        try {
            conn.ix().checkinDocEnd(null, null, doc, LockC.YES);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Beispiel 32: Dateiausschnitt lesen
        objId = "92233";
        long offset = 10; 
        long length = 100;

        // file = System.IO.Path.GetTempFileName();
        file = "E:\\Temp\\KurzerText.txt";

        try {
            ed = conn.ix().checkoutDoc(objId, null, EditInfoC.mbDocument, LockC.YES);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        DocVersion dv1 = ed.getDocument().getDocs()[0];

        if (offset > dv1.getSize()) offset = dv1.getSize(); 
        if (offset + length > dv1.getSize()) length = dv1.getSize() - offset; 

        String url = dv1.getUrl() + "&offset=" + offset + "&length=" + length;
        try {
            conn.download(url,new File(file));
        }
        catch (RemoteException e) {
            e.printStackTrace();
        }

        // Beispiel 33: Einfügen eines kleinen Dokuments
        String fileContent = "This is an example text file";

        String arcPath = "ARCPATH:/Tests";
        try {
            ed = conn.ix().checkoutSord(arcPath, EditInfoC.mbOnlyId, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        try {
            ed = conn.ix().createSord(ed.getSord().getId() + "", "", EditInfoC.mbSordDoc);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        ed.getSord().setName("Small Document");

        ed.setDocument(new Document());
        ed.getDocument().setDocs(new DocVersion[] { new DocVersion() }); 
        ed.getDocument().getDocs()[0].setContentType("text/plain"); 
        ed.getDocument().getDocs()[0].setFileData(new FileData()); 
        ed.getDocument().getDocs()[0].getFileData().setData(fileContent.getBytes(StandardCharsets.US_ASCII));

        try {
            objId = conn.ix().checkinDocEnd(ed.getSord(), SordC.mbAll, ed.getDocument(), LockC.NO).getObjId();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Beispiel 34: Lesen eines kleinen Dokuments
        SordZ sordZ = new SordZ(SordC.mbSmallDocumentContent); 

        try { 
            ed = conn.ix().checkoutSord(objId, new EditInfoZ(0, sordZ), LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        byte [] b = ed.getSord().getDocVersion().getFileData().getData();        
        String fileContent1 = new String(b, 0, b.length, StandardCharsets.US_ASCII);

        // Beispiel 35: Content-Type statt Dateiendung beim Einchecken eines Dokuments
        parentId = ed.getSord().getId() + "";
        maskId = "0";
        file = "E:\\Temp\\Volltext.txt"; 
        String contentType = "text/plain";

        try { 
            ed = conn.ix().createDoc(parentId, maskId, null, EditInfoC.mbSordDoc);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        ed.getSord().setName("My ContentType Document"); 

        doc = new Document(); 
        doc.setDocs(new DocVersion[] { new DocVersion() }); 
        doc.getDocs()[0].setPathId(ed.getSord().getPath()); 
        doc.getDocs()[0].setEncryptionSet(ed.getSord().getDetails().getEncryptionSet()); 
        doc.getDocs()[0].setContentType(contentType); 

        try { 
            doc = conn.ix().checkinDocBegin(doc);
            doc.getDocs()[0].setUploadResult(conn.upload(doc.getDocs()[0].getUrl(),new File(file))); 
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // doc = conn.ix().checkinDocEnd(ed.getSord(), SordC.mbAll, doc, LockC.NO);

        // Beispiel 36: Versionskommentar nachträglich ändern
        objId = "92233";
        try { 
            ed = conn.ix().checkoutDoc(objId, null, EditInfoC.mbDocument, LockC.FORCE);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        doc = ed.getDocument(); 

        doc.getDocs()[0].setVersion("1.1"); 
        doc.getDocs()[0].setVersion("My version comment"); 
        doc.getDocs()[0].setMilestone(true); 

        try {
            conn.ix().checkinDocEnd(null, null, doc, LockC.YES);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        //Beispiel 37: Arbeitsversion ändern
        objId = "92233"; 
        int newWorkVersionIdx = 1; 

        try { 
            ed = conn.ix().checkoutDoc(objId, "-1", EditInfoC.mbDocument, LockC.FORCE);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        doc = ed.getDocument();
        DocVersion dv2 = doc.getDocs()[newWorkVersionIdx]; 
        dv2.setWorkVersion(true); 

        Document doc2 = new Document(); 
        doc2.setObjId(doc.getObjId()); 
        doc2.setDocs(new DocVersion[] { dv2 }); 

        try {
            conn.ix().checkinDocEnd(null, null, doc2, LockC.YES);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        //Beispiel 38: Dokumentversion löschen
        objId = "92403";
        int deleteVersionIdx = 1; 

        try { 
            ed = conn.ix().checkoutDoc(objId, "-1", EditInfoC.mbDocument, LockC.FORCE);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        doc = ed.getDocument(); 
        DocVersion dv3 = doc.getDocs()[deleteVersionIdx];
        dv3.setDeleted(true);

        doc2 = new Document(); 
        doc2.setObjId(doc.getObjId()); 
        doc2.setDocs(new DocVersion[] { dv3 });

        try {
            conn.ix().checkinDocEnd(null, null, doc2, LockC.YES);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        //Beispiel 39: Dublettenprüfung
        fileName = "E:\\Temp\\Test2.txt";

        // Compute MD5 hash 
        String md5 = ""; 
        try {
            md5 = conn.getFileMd5(new File(fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try  { 
            // Read document by MD5 hash 
            String objId2 = "MD5:" + md5; 
            EditInfo ed1 = conn.ix().checkoutSord(objId2, EditInfoC.mbOnlyId, LockC.NO); 
            System.out.println("file already exists with objId=" + ed1.getSord().getId()); 
        }
        catch (RemoteException e) { 
            try {
                if (conn.ix().parseException(e.toString()).getExceptionType() != IXExceptionC.NOT_FOUND) {
                    // other error
                    throw e; 
                }
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
            System.out.println("file does not exist"); 
        }

        //Beispiel 40: Dokumente duplizieren
        objId = "92233";

        try {
            ed = conn.ix().checkoutDoc(objId, "-1", EditInfoC.mbSordDocAtt, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Mark Sord object as new 
        ed.getSord().setId(-1); 
        ed.getSord().setGuid(""); 

        doc = ed.getDocument(); 
        try { 
            doc = conn.ix().checkinDocDupl(ed.getSord(), SordC.mbAll, doc, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        System.out.println("objId=" + doc.getObjId());

        //Beispiel 41: Dokumente in einen anderen Ablagepfad verschieben
        String path2Id = "93603"; // Path2
        parentId = "93598"; // Path1

        NavigationInfo navInfo = new NavigationInfo(); 
        navInfo.setStartIDs(new String[] { parentId }); 

        ProcessInfo procInfo = new ProcessInfo(); 
        procInfo.setProcMoveDocumentsToStoragePath(new ProcessMoveDocumentsToStoragePath());
        procInfo.getProcMoveDocumentsToStoragePath().setPathId(path2Id); 

        BackgroundJobLoop(conn, navInfo, procInfo);

        //Beispiel 42: Verschlüsseltes Dokument anlegen und lesen

        // --- Step1 set Indexserver options for encryption ----------

        conn.getSessionOptions().setProperty(SessionOptionsC.ENCRYPT_DOCUMENTS, "true"); 
        conn.getSessionOptions().setProperty(SessionOptionsC.DECRYPT_DOCUMENTS, "true"); 
        
        KeyValue[] kvs = new KeyValue[conn.getSessionOptions().size()];
        int index = 0;
        for(Object key : conn.getSessionOptions().keySet()) {
            kvs[index].setKey(key.toString());
            kvs[index].setValue(conn.getSessionOptions().get(key).toString());
            index++;            
        }
        // SessionOptions sessOpts = IXSessionOptions.makeSessOptsObj(conn.getSessionOptions());
        SessionOptions sessOpts = new SessionOptions();
        sessOpts.setOptions(kvs);
        
        try {
            conn.ix().setSessionOptions(sessOpts);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // --- Step2 provide the encryption password ----------------- 

        int encrSetId = 11; 
        String encrPassword = "elo"; 

        conn.getLogin().getEncrPasswords().setProperty(Integer.toString(encrSetId), encrPassword);
        try {
            String pwdEncr; 
            pwdEncr = conn.encryptPassword(encrPassword);
            conn.ix().provideCryptPassword(Integer.toString(encrSetId), pwdEncr);            
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // --- Step3 checkin encrypted document ---------------------- 

        parentId = ed.getSord().getId() + ""; 
        maskId = "0";
        file = "E:\\Temp\\Test3.png"; 

        try { 
            ed = conn.ix().createDoc(parentId, maskId, null, EditInfoC.mbSordDoc);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        sord = ed.getSord(); 
        sord.setName("My document enc"); 
        sord.getDetails().setEncryptionSet(encrSetId); 

        doc = new Document(); 
        doc.setDocs(new DocVersion[] { new DocVersion() }); 
        doc.getDocs()[0].setPathId(sord.getPath()); 
        doc.getDocs()[0].setEncryptionSet(sord.getDetails().getEncryptionSet()); 
        doc.getDocs()[0].setExt(conn.getFileExt(file)); 

        try {
            doc = conn.ix().checkinDocBegin(doc);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        try {
            // upload,
            // the Indexserver encrypts the document and
            // passes it to the Document Manager
            doc.getDocs()[0].setUploadResult(conn.upload(doc.getDocs()[0].getUrl(),new File(file)));
            doc = conn.ix().checkinDocEnd(sord, SordC.mbAll, doc, LockC.NO); 
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        System.out.println("objId=" + doc.getObjId());

        try {
            // --- Step4 checkout encrypted document ----------------------
            ed = conn.ix().checkoutDoc(doc.getObjId(), null, EditInfoC.mbSordDoc, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        dv1 = ed.getDocument().getDocs()[0]; 
        // String file2 = System.IO.Path.GetTempFileName() + "." + dv1.getExt(); 
        File file2 = new File("");        
        try {
            file2 = File.createTempFile("test", "." + dv1.getExt());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            conn.download(dv1.getUrl(), file2);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        file2.deleteOnExit();        

        //Beispiel 43: Verschlüsselungskennwörter ändern
        String encrSetId1 = "11";
        String oldPassword = "elo";
        String newPassword = "elo";

        // provide current encryption password 
        try {
            String pwdEncr = conn.encryptPassword(oldPassword);
            conn.ix().provideCryptPassword(encrSetId1, pwdEncr); 
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // read key information 
        CryptInfo cryptInfo = new CryptInfo(); 
        try {
            cryptInfo = conn.ix().checkoutCryptInfos(new String[] { encrSetId1 }, LockC.YES)[0];
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        try {
            // assign new password, clear internal key data
            cryptInfo.setPwd(conn.encryptPassword(newPassword));
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        cryptInfo.setKeyInfo(""); 

        try {
            // checkin key information
            conn.ix().checkinCryptInfos(new CryptInfo[] { cryptInfo }, LockC.YES);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

    }

    static void OrdnerUndDokumentTypen() {
        //Beispiel 44: Ordner und Dokumente unterscheiden
        IXConnFactory connFact = new IXConnFactory("http://playground.dev.elo/ix-Solutions/ix", "OrdnerUndDokumentTypen", "1.0");
        IXConnection conn = (IXConnection) new Object();
        try {
            conn = connFact.create("Administrator", "elo", "localhost", null);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        String objId = "ARCPATH:/Administration/Business Solutions/recruiting [unit tests]/Test data";

        EditInfo ed = new EditInfo();
        try {
            ed = conn.ix().checkoutSord(objId, EditInfoC.mbSordLean, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        Sord sord = ed.getSord(); 
        boolean isFolder = sord.getType() < SordC.LBT_DOCUMENT; 
        boolean isDocument = sord.getType() >= SordC.LBT_DOCUMENT && sord.getType() <= SordC.LBT_DOCUMENT_MAX; 
        boolean isArchive = sord.getType() == SordC.LBT_ARCHIVE; 

        System.out.println("isFolder=" + isFolder); 
        System.out.println("isDocument=" + isDocument);
        System.out.println("isArchive=" + isArchive);

        //Beispiel 45: Vereinfachte Unterscheidung von Ordnern und Dokumenten
        if (sord.getId() > 1) { 
            //isFolder = sord.getType() < SordC.LBT_DOCUMENT; 
            //isDocument = sord.getType() >= SordC.LBT_DOCUMENT; 
        }

        try {
            //Beispiel 46: Archivobjekt auslesen
            ed = conn.ix().checkoutSord("1", EditInfoC.mbSordLean, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        sord = ed.getSord();

        System.out.println("Archive name=" + sord.getName()); 
        System.out.println("sord.getType()=" + sord.getType()); // 9999 

        // print users and groups with granted access to first archive level 
        for (AclItem ai : sord.getAclItems()) { 
            boolean canAddDel = (ai.getAccess() & AccessC.LUR_LIST) != 0; 
            System.out.println("user/group=" + ai.getName() + " can add/delete=" + canAddDel); 
        }

        // print access for the current user 
        {
            boolean canAddDel = (sord.getAccess() & AccessC.LUR_LIST) != 0; 
            System.out.println("current user=" + conn.getUserName() + " can add/delete=" + canAddDel);
        }

        //Beispiel 47: Ordner unter parentId anlegen
        String parentId = "ARCPATH:/Administration/Business Solutions/recruiting [unit tests]/Test data"; 

        try { 
            ed = conn.ix().createSord(parentId, "", EditInfoC.mbSord);
            ed.getSord().setName("Tutorial-test"); 
            ed.getSord().setId(conn.ix().checkinSord(ed.getSord(), SordC.mbAll, LockC.NO)); 
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        System.out.println("sord.getId()=" + ed.getSord().getId());

        try {
            //Beispiel 48: Ordner in der Chaosablage speichern
            ed = conn.ix().createSord("0", "", EditInfoC.mbSord);
            ed.getSord().setName("Tutorial-test"); 
            ed.getSord().setId(conn.ix().checkinSord(ed.getSord(), SordC.mbAll, LockC.NO)); 
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        System.out.println("sord.getId()=" + ed.getSord().getId() + ", parentId=" + ed.getSord().getParentId()); // = 0   

        //Beispiel 49: Archivpfad anlegen
        int lastObjId = MakeArcPath(conn, "1", "/Tests/Test Jan/NewDoc2010/A"); 
        System.out.println("lastObjId=" + lastObjId);

        //Beispiel 50: Pfad mit zusätzlichen Eigenschaften anlegen

        // (1) read default storage mask for folder objects 
        String folderMaskId = ""; 
        DocMask folderMask = new DocMask();
        try {
            folderMaskId = conn.getCONST().getDOC_MASK().getGUID_FOLDER();
            folderMask = conn.ix().checkoutDocMask(folderMaskId, DocMaskC.mbAll, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // (2) create ACL for protected archive levels 
        // Bookkeeping and Invoices 
        AclItem[] aclProtected = new AclItem[2]; 
        aclProtected[0] = MakeAclItem(AclItemC.TYPE_USER, UserInfoC.ID_ADMINISTRATOR, AccessC.LUR_ALL); 
        aclProtected[1] = MakeAclItem(AclItemC.TYPE_GROUP, UserInfoC.ID_EVERYONE_GROUP, AccessC.LUR_READ);

        // (3) create ACL for public archive level 2010 
        AclItem[] aclPublic = new AclItem[2]; 
        aclPublic[0] = MakeAclItem(AclItemC.TYPE_USER, UserInfoC.ID_ADMINISTRATOR, AccessC.LUR_ALL); 
        aclPublic[1] = MakeAclItem(AclItemC.TYPE_GROUP,UserInfoC.ID_EVERYONE_GROUP, AccessC.LUR_READ|AccessC.LUR_LIST);

        // (4) initialize the sords 
        Sord[] sords = new Sord[4];

        try { 
            sords[0] = conn.ix().createSord(parentId, folderMaskId, EditInfoC.mbSord).getSord();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        sords[0].setName("ZZZZ"); 
        sords[0].setType(1); 
        sords[0].getDetails().setSortOrder(SortOrderC.ALPHA); 
        sords[0].setAclItems(aclProtected); 
        sords[0].getObjKeys()[0].setName("ELOINDEX"); 
        sords[0].getObjKeys()[0].setData(new String[] { "ZZZZ" });

        try { 
            sords[1] = conn.ix().createSord(parentId, folderMaskId, EditInfoC.mbSord).getSord();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        sords[1].setName("Invoices"); 
        sords[1].setType(2); 
        sords[1].getDetails().setSortOrder(SortOrderC.IALPHA); 
        sords[1].setAclItems(aclProtected); 
        sords[1].getObjKeys()[0].setName("ELOINDEX"); 
        sords[1].getObjKeys()[0].setData(new String[] { "Invoices" });

        try {
            sords[2] = conn.ix().createSord(parentId, folderMaskId, EditInfoC.mbSord).getSord();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        sords[2].setName("2010"); 
        sords[2].setType(3); 
        sords[2].getDetails().setSortOrder(SortOrderC.ALPHA); 
        sords[2].setAclItems(aclPublic); 
        sords[2].getObjKeys()[0].setName("ELOINDEX"); 
        sords[2].getObjKeys()[0].setData(new String[] { "Invoices2010" });

        try { 
            sords[3] = conn.ix().createSord(parentId, folderMaskId, EditInfoC.mbSord).getSord();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        sords[3].setName("A"); 
        sords[3].setType(4); 
        sords[3].getDetails().setSortOrder(SortOrderC.ALPHA); 
        sords[3].setAclItems(folderMask.getDocAclItems()); 
        sords[3].getObjKeys()[0].setName("ELOINDEX"); 
        sords[3].getObjKeys()[0].setData(new String[] { "Invoices2010A" });

        // (5) create a bitset that contains the bits of all 
        // valid member 
        long validMembers = SordC.mbName | SordC.mbMask | SordC.mbAclItems | SordC.mbDetails | SordC.mbObjKeys | SordC.mbType;

        try {
            // (6) create the path
            conn.ix().checkinSordPath(parentId, sords, new SordZ(validMembers));
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Beispiel 51: Archivpfad ermitteln
        objId = "ARCPATH:/Administration/Business Solutions/recruiting [unit tests]/Test data";

        // Prepare optimal element selector
        SordZ sordZ = new SordZ(SordC.mbParentIds | SordC.mbRefPaths); 
        EditInfoZ editZ = new EditInfoZ(0, sordZ); 

        try { 
            ed = conn.ix().checkoutSord(objId, editZ, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        String[] parentIds = ed.getSord().getParentIds(); 
        ArcPath[] refPaths = ed.getSord().getRefPaths(); 
        for (int i = 0; i < parentIds.length; i++) { 
            String text = (i == 0) ? "main path" : "reference path"; 
            System.out.println(text + ", parentId=" + parentIds[i] + ", path=" + refPaths[i].getPathAsString());
        }

        // Beispiel 52: Objekt-ID zum Archivpfad ermitteln
        String arcPath = "ARCPATH:/Tests/Test Jan/NewDoc2010/A"; 
        try { 
            ed = conn.ix().checkoutSord(arcPath, EditInfoC.mbOnlyId, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        System.out.println("sord.getId()=" + ed.getSord().getId());

        // Beispiel 53: Objekt-ID ermitteln zum Archivpfad mit Startpunktangabe
        arcPath = "ARCPATH:/Tests/Test Jan";
        try {
            ed = conn.ix().checkoutSord(arcPath, EditInfoC.mbOnlyId, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        objId = ed.getSord().getId() + ""; // ID or GUID 
        arcPath = "ARCPATH[" + objId + "]:/NewDoc2010/A"; 
        try { 
            ed = conn.ix().checkoutSord(arcPath, EditInfoC.mbOnlyId, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        System.out.println("sord.getId()=" + ed.getSord().getId());

        // Beispiel 54: Ablage über Indexaufbau

        // create a storage mask with a filing clause 
        String maskName = "TestJan"; 
        DocMask dm = new DocMask(); 
        try {
            dm = conn.ix().createDocMask("");
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        dm.setName(maskName);
        dm.setIndex("[¶Tests¶Test Jan¶]+LD"); 
        dm.getDetails().setCreateIndexPath(true) ;        
        try {
            dm.setId(conn.ix().checkinDocMask(dm, DocMaskC.mbAll, LockC.NO));
        }
        catch (RemoteException e)  {
            e.printStackTrace();
        }

        try {
            // create a sord object
            ed = conn.ix().createSord("0", maskName, EditInfoC.mbSord);
            ed.getSord().setName("My sord"); 
            ed.getSord().setXDateIso(conn.dateToIso( new Date(2010, 05, 01, 12, 00, 00))); 
            ed.getSord().setId(conn.ix().checkinSord(ed.getSord(), SordC.mbAll, LockC.NO));
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Beispiel 55: Untereinträge auflisten
        arcPath = "ARCPATH:/Tests";
        try {
            ed = conn.ix().checkoutSord(arcPath, EditInfoC.mbOnlyId, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        int parentId1 = ed.getSord().getId(); 
        FindChildren(conn, parentId1);

        // Beispiel 56: Enthält ein Ordner Untereinträge?
        objId = ed.getSord().getId() + "";
        try {
            ed = conn.ix().checkoutSord(objId, EditInfoC.mbSord, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        sord = ed.getSord();
        boolean hasChildren = sord.getChildCount() > 0;
        Sord dynReg = new Sord();
        try {
            // Beispiel 57: Dynamisches Register erstellen und auflisten
            ed = conn.ix().createSord(objId, "", EditInfoC.mbSord);
            dynReg = ed.getSord(); 
            dynReg.setName("Dynamic Register"); 
            dynReg.setDesc("!+ , objkeys ok1 where " + " objid=ok1.parentid and" + " ok1.okeyname='ELOOUTL1' and" + " ok1.okeydata like '%' "); 
            dynReg.setId(conn.ix().checkinSord(dynReg, SordC.mbAll, LockC.NO)); 
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        FindChildren(conn, dynReg.getId());

        try {
            // Beispiel 58: Ordner mit alphabetischer Sortierung der Untereinträge anlegen
            ed = conn.ix().createSord(objId, "", EditInfoC.mbSord);
            ed.getSord().setName("Folder1");
            ed.getSord().getDetails().setSortOrder(SortOrderC.ALPHA); 
            ed.getSord().setId(conn.ix().checkinSord(ed.getSord(), SordC.mbAll, LockC.NO));
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Beispiel 59: Referenz (logische Kopie) anlegen
        String folderId4 = InsertSord(conn, objId, "Folder4");
        String folderId5 = InsertSord(conn, objId, "Folder5");
        String subFolderId41 = InsertSord(conn, folderId4, "SubFolder41"); 
        try {
            conn.ix().refSord("", folderId5, subFolderId41, -1);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Beispiel 60: Links anlegen

        // create some folders 
        String folderId1 = InsertSord(conn, objId, "Folder1");
        String folderId2 = InsertSord(conn, objId, "Folder2");
        String folderId3 = InsertSord(conn, objId, "Folder3"); 

        try {
            // link Folder1 to Folder2 and Folder3
            conn.ix().linkSords(folderId1, new String[] {folderId2, folderId3}, null);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // read link information of Folder1 
        editZ = new EditInfoZ(0, new SordZ(SordC.mbLinks)); 
        Sord folder1 = new Sord(); 
        try {
            folder1 = conn.ix().checkoutSord(folderId1, editZ, LockC.NO).getSord();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // loop over link information 
        for (SordLink link : folder1.getLinksGoOut()) { 
            Sord sord3 = new Sord(); 
            try {
                sord3 = conn.ix().checkoutSord(link.getId(), EditInfoC.mbSordLean, LockC.NO).getSord();
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
            System.out.println("linked sord.getName()=" + sord3.getName()); 
        }

        // Beispiel 61: Verschieben einer Referenz
        String folderId6 = InsertSord(conn, objId, "Folder6");
        String folderId7 = InsertSord(conn, objId, "Folder7"); 
        String subFolderId61 = InsertSord(conn, folderId6, "SubFolder61"); 

        try {
            conn.ix().refSord(folderId6, folderId7, subFolderId61, -1);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Beispiel 62: Verschieben und Anpassen der Berechtigungen
        CopyInfo copyInfo = new CopyInfo(); 
        copyInfo.setAdjustAclDifference(true); 
        copyInfo.setAdjustAclInBackground(true); 
        try {
            conn.ix().copySord(folderId2, subFolderId41, copyInfo, CopySordC.MOVE);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Beispiel 63: Archiveintrag logisch löschen
        arcPath = "ARCPATH:/Tests";
        try {
            ed = conn.ix().checkoutSord(arcPath, EditInfoC.mbOnlyId, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        parentId = ed.getSord().getId() + ""; 
        objId = folderId7; 
        try {
            conn.ix().deleteSord(parentId, objId, LockC.NO, null);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Beispiel 64: Archiveintrag physikalisch löschen
        parentId = ed.getSord().getId() + "";
        objId = folderId6; 

        DeleteOptions delOpts = new DeleteOptions(); 
        delOpts.setDeleteFinally(true); 

        try {
            conn.ix().deleteSord(parentId, objId, LockC.NO, delOpts);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Beispiel 65: Dauerhaftes Entfernen im Hintergrund
        delOpts = new DeleteOptions(); 
        delOpts.setDeleteFinally(true); 
        delOpts.setMaxTStamp("2010.03.15.00.00.00"); // dots are important 
        CleanupLoop(conn, delOpts);

        // Beispiel 66: Löschen von Verfallsdokumenten
        delOpts = new DeleteOptions(); 
        delOpts.setDeleteExpiredOnly(true); 

        delOpts.setDeleteFinally(false); 
        CleanupLoop(conn, delOpts);

        delOpts.setDeleteFinally(true); 
        CleanupLoop(conn, delOpts);

        // Beispiel 68: Archivstruktur kopieren

        // (0) create example structure 
        objId = ed.getSord().getId() + "";
        String mainFolderId = InsertSord(conn, objId, "Main Folder"); 
        String folderId8 = InsertSord(conn, mainFolderId, "Folder8"); 
        String subFolderId81 = InsertSord(conn, folderId8, "SubFolder81"); 
        String subFolderId82 = InsertSord(conn, folderId8, "SubFolder82"); 
        String subFolderId83 = InsertSord(conn, folderId8, "SubFolder83");

        // (1) supply the ID of the folder to be copied 
        NavigationInfo navInfo = new NavigationInfo(); 
        navInfo.setStartIDs(new String[] { folderId8 }); 
        navInfo.setIgnoreDocuments(true); 

        // (2) supply the ID of the destination folder 
        CopyOptions copyOpts = new CopyOptions(); 
        copyOpts.setNewParentId(Integer.getInteger(mainFolderId)); 
        copyOpts.setTargetName("Copy of Folder8"); 

        // (3) create a ProcessInfo object and assign the copy options 
        ProcessInfo procInfo = new ProcessInfo(); 
        procInfo.setDesc("My copy folder job"); 
        procInfo.setProcCopyElements(new ProcessCopyElements()); 
        procInfo.getProcCopyElements().setCopyOptions(copyOpts);

        // (4) start and watch the copy job. 
        BackgroundJobLoop(conn, navInfo, procInfo);

        // Beispiel 69: Berechtigungen auf Struktur hinzufügen

        // Step0: create example structure 
        String folderId9 = InsertSord(conn, objId, "Folder9"); 
        String subFolderId91 = InsertSord(conn, folderId9, "SubFolder91");

        // Step1: create example user 
        UserInfo ui = new UserInfo();
        try {
            ui = conn.ix().createUser("");
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        ui.setName("Fritz");

        try {
            ui.setId(conn.ix().checkinUsers(new UserInfo[] { ui }, CheckinUsersC.WRITE, LockC.NO)[0]);
        }
        catch (RemoteException e) { 
            e.printStackTrace();
        }

        // Step2: create ACL item for user with read access 
        AclItem aclItem = new AclItem();
        aclItem.setType(AclItemC.TYPE_USER);
        aclItem.setId(ui.getId());
        aclItem.setName(ui.getName());
        aclItem.setAccess(AccessC.LUR_READ);

        // Step3: supply the ID of the target folder 
        navInfo = new NavigationInfo(); 
        navInfo.setStartIDs(new String[] { folderId9 }); 
        navInfo.setIgnoreDocuments(true); 

        // Step4: create a ProcessInfo object with the ACL information 
        procInfo = new ProcessInfo(); 
        procInfo.setProcAcl(new ProcessAcl()); 
        procInfo.getProcAcl().setAddAclItems(new AclItem[] { aclItem }); 

        // Step5: assign the ACL in a background job 
        BackgroundJobLoop(conn, navInfo, procInfo);

        // Beispiel 69: Untereinträge zählen

        // Step0: create example structure 
        String folderId10 = InsertSord(conn, objId, "Folder10"); 
        String subFolderId101 = InsertSord(conn, folderId10, "SubFolder101"); 
        String subFolderId102 = InsertSord(conn, folderId10, "SubFolder102");

        // Step1: supply the ID of the folder to count 
        navInfo = new NavigationInfo(); 
        navInfo.setStartIDs(new String[] { folderId10 });

        // Step2: 
        procInfo = new ProcessInfo(); 
        procInfo.setProcCountElem(new ProcessCountElements()); 
        procInfo.getProcCountElem().setCountResult(new CountResult()); 

        String jobGuid = BackgroundJobLoop(conn, navInfo, procInfo); 

        JobState jobState = new JobState(); 
        try {
            jobState = conn.ix().queryJobState(jobGuid, true, true, true);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        if (jobState != null) { 
            CountResult countResult = jobState.getProcInfo().getProcCountElem().getCountResult();

            System.out.println("#folders=" + // = 3 
                    Integer.toString(countResult.getStructCount()) + 
                    ", #docs=" + // = 0 
                    Integer.toString(countResult.getDocCount())); 
        }

        
    }

    static void Verschlagwortung() {
        // Beispiel 70: Liste der Verschlagwortungsmasken
        IXConnFactory connFact = new IXConnFactory("http://srvpdevbs01vm:8030/ix-common/ix", "Verschlagwortung", "1.0");
        IXConnection conn = (IXConnection) new Object();
        try {
            conn = connFact.create("Administrator", "ELObs!dev", "localhost", null);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        String arcPath = "ARCPATH:/Tests";
        EditInfo ed = new EditInfo();
        try {
            ed = conn.ix().checkoutSord(arcPath, EditInfoC.mbOnlyId, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }


        String parentId = ed.getSord().getId() + ""; 

        EditInfoZ editZ = new EditInfoZ(EditInfoC.mbMaskNames, new SordZ());
        try { 
            ed = conn.ix().createSord(parentId, "", editZ);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        for (MaskName mn : ed.getMaskNames()) { 
            boolean canRead = (mn.getAccess() & AccessC.LUR_READ) != 0; 
            System.out.println("id=" + Integer.toString(mn.getId()) +
                ", name=" + mn.getName() + 
                ", folderMask=" + Boolean.toString(mn.isFolderMask()) + 
                ", documentMask=" + Boolean.toString(mn.isDocumentMask()) + 
                ", searchMask=" + Boolean.toString(mn.isSearchMask()) + 
                ", canRead=" + Boolean.toString(canRead)); 
        }

        // Beispiel 71: Neue Verschlagwortungsmaske einfügen

        // Step1: initialize a DocMask object 
        DocMask dm = new DocMask(); 
        try {
            dm = conn.ix().createDocMask("");
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        dm.setName("My keywording form"); 

        // Step2: set some options 
        dm.getDetails().setFolderMask(false); 
        dm.getDetails().setFulltext(true); 

        // Step3: create two input lines 
        dm.setLines(new DocMaskLine[2]); 
        dm.getLines()[0] = new DocMaskLine(); 
        dm.getLines()[0].setId(0); 
        dm.getLines()[0].setName("Text value"); 
        dm.getLines()[0].setKey("VALUE1"); 
        dm.getLines()[1] = new DocMaskLine(); 
        dm.getLines()[1].setId(0); 
        dm.getLines()[1].setName("Numeric value 999.99"); 
        dm.getLines()[1].setKey("VALUE2"); 
        dm.getLines()[1].setType(DocMaskLineC.TYPE_NUMBER_F2); 
        dm.getLines()[1].setMax(6);

        // Access to everyone 
        AclItem[] aclItem = new AclItem[] { new AclItem() }; 
        aclItem[0].setType(AclItemC.TYPE_GROUP); 
        aclItem[0].setId(UserInfoC.ID_EVERYONE_GROUP); 
        aclItem[0].setAccess(AccessC.LUR_ALL); 
        dm.getLines()[0].setAclItems(aclItem); 
        dm.getLines()[1].setAclItems(aclItem);

        // Step4: insert into archive database 
        try {
            dm.setId(conn.ix().checkinDocMask(dm, DocMaskC.mbAll, LockC.NO));
        }
        catch (RemoteException e) {
            e.printStackTrace();
        }


        try {
            // Beispiel 71: Dokumenten- und Ablagedatum verwenden
            ed = conn.ix().checkoutSord(parentId, EditInfoC.mbSord, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // --- To obtain Date objects from ISO Strings … 
        Date iDate = conn.isoToDate(ed.getSord().getIDateIso()); 
        Date xDate = conn.isoToDate(ed.getSord().getXDateIso());

        // --- To obtain ISO Strings from Date objects … 
        ed.getSord().setIDateIso(conn.dateToIso(iDate)); 
        ed.getSord().setXDateIso(conn.dateToIso(xDate));

        try {
            // Beispiel 72: Maximallänge für Kurzbezeichnung und Zusatztext
            int maxNameLength = conn.getCONST().getSORD().getLnName();
            int maxDescLength = conn.getCONST().getSORD().getLnDesc();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Beispiel 73: Funktion IXConnection.truncate
        Sord sord = ed.getSord();
        boolean canStore;
        try {
            canStore = sord.getName().equals(conn.truncate(sord.getName(), conn.getCONST().getSORD().getLnName()));
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Beispiel 74: Zusammenhang von DocMaskLine und ObjKey
        String objId = "86962";
        editZ = new EditInfoZ(EditInfoC.mbMask, SordC.mbLean);
        try { 
            ed = conn.ix().checkoutSord(objId, editZ, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        for (int i = 0; i < ed.getMask().getLines().length; i++) { 
            DocMaskLine dml = ed.getMask().getLines()[i]; 
            ObjKey okey = ed.getSord().getObjKeys()[i]; 

            // ID is equal to array index: i == dml.getId() && i == okey.getId(); 

            String okeyValue = "";                 
            if (okey.getData().length != 0) okeyValue = okey.getData()[0]; 
            System.out.println(dml.getName() + "=" + okeyValue); 
        }

        // Beispiel 75: Zugriffsprüfung auf Indexfelder
        /*
        DocMaskLine dml = … 

        bool canEdit = (dml.getAccess() & AccessC.LUR_WRITE) != 0; 
        bool canRead = (dml.getAccess() & AccessC.LUR_READ) != 0; 

        Control textBox = new TextBox(); 
        textBox.Visible = canRead && !dml.hidden; 
        textBox.Enabled = canEdit && !dml.readOnly;
        */

        // Beispiel 76: Maximale Anzahl der Zeichen für Indexwerte
        int maxValueLength = 0;
        try {
            maxValueLength = conn.getCONST().getOBJ_KEY().getLnData();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        String value = "GGGGGGGGGGGG";
        canStore = sord.getName().equals(conn.truncate(value, maxValueLength));

        // Beispiel 77: Verwendung von ISO-Datumsangaben aus ObjKey

        // --- To obtain Date objects from ISO Strings … 
        IXConnection.staticIsoToDate(ed.getSord().getIDateIso(), false);
        // Date okeyDate = IXConnection.staticIsoToDate( ed.getSord().getObjKeys()[0].getData()[0], false);
        Date okeyDate = IXConnection.staticIsoToDate(ed.getSord().getIDateIso(), false); 

        // --- To obtain ISO Strings from Date objects … 
        String isoDateAndTime = IXConnection.staticDateToIso( okeyDate, false); 
        ed.getSord().getObjKeys()[0].getData()[0] = (isoDateAndTime.length() != 0) ? isoDateAndTime.substring(0, 8) : "";

        // Beispiel 78: Numerische Indexwerte
        String maskName = "MyMask";

        // create new mask with one numeric index line 
        try { 
            conn.ix().deleteDocMask(maskName, "0", LockC.NO); 
        } 
        catch (RemoteException e) { 
            e.printStackTrace();
        } 

        try { 
            dm = conn.ix().createDocMask("");
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        dm.setName(maskName); 
        dm.getDetails().setFolderMask(false); 
        dm.getDetails().setFulltext(true); 
        dm.setLines(new DocMaskLine[1]); 
        dm.getLines()[0] = new DocMaskLine(); 
        dm.getLines()[0].setId(0);
        dm.getLines()[0].setName("Numeric value"); 
        dm.getLines()[0].setKey("VALUE1"); 
        dm.getLines()[0].setType(DocMaskLineC.TYPE_NUMBER_F2); 
        dm.getLines()[0].setMax(6); 
        try { 
            dm.setId(conn.ix().checkinDocMask(dm, DocMaskC.mbAll, LockC.NO));
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // This double value has to be stored: 
        double dblValue = 123.45; 

        // Convert the double value into a String 
        String strValue = Double.toString(dblValue); 

        try {
            // Create a Sord object and assign the numeric value
            ed = conn.ix().createSord(parentId, maskName, EditInfoC.mbSordLean);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        ed.getSord().setName("numeric test"); 
        ed.getSord().getObjKeys()[0].setData(new String[] { strValue }); 
        try { 
            ed.getSord().setId(conn.ix().checkinSord(ed.getSord(), SordC.mbLean, LockC.NO));
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        try {
            // Read the Sord object
            ed = conn.ix().checkoutSord(Integer.toString(ed.getSord().getId()), EditInfoC.mbSordLean, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        String strValue2 = ed.getSord().getObjKeys()[0].getData()[0]; 

        // Convert the String value into a double value 
        double dblValue2 = Double.parseDouble(strValue2); 

        // Beispiel 80: Stichwortliste lesen
        String kwId = KeywordC.KWID_STANDARD_LIST; 
        Keyword kw = new Keyword(); 
        try {
            kw = conn.ix().checkoutKeywords(new String[] { kwId }, KeywordC.mbView, 1000, LockC.NO)[0];
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        DumpKeywordList(conn, 0, kw);

        // Beispiel 81: Stichwörter im EditInfo-Objekt

        objId = "86962";
        try { 
            ed = conn.ix().checkoutSord(objId, EditInfoC.mbAll, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        for (Keyword kw1 : ed.getKeywords()) { 
            System.out.println(kw1.getId() + ": " + kw1.getText()); 
        }


        // Beispiel 82: Erstellen und Bearbeiten einer Stichwortliste

        // --- create a keyword list ----------------------------------- 

        String kwRootId = "MYKEYWORDLIST"; 

        // "virtual" root object 
        kw = new Keyword(); 
        kw.setId(kwRootId); 

        // children: keyword list entries 
        kw.setChildren(new Keyword[3]); 
        kw.getChildren()[0] = new Keyword(); 
        kw.getChildren()[0].setText("one"); 
        kw.getChildren()[0].setEnabled(true); 
        kw.getChildren()[1] = new Keyword(); 
        kw.getChildren()[1].setText("two"); 
        kw.getChildren()[1].setEnabled(true); 
        kw.getChildren()[1].setChildren(new Keyword[1]); 
        kw.getChildren()[1].getChildren()[0] = new Keyword(); 
        kw.getChildren()[1].getChildren()[0].setText("two.one"); 
        kw.getChildren()[2] = new Keyword(); 
        kw.getChildren()[2].setText("three");
        kw.getChildren()[2].setEnabled(true); 

        try {
            // store keyword list
            conn.ix().checkinKeywords(new Keyword[] { kw }, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        try {
            // read keyword list and dump entries
            kw = conn.ix().checkoutKeywords(new String[] { kwRootId }, KeywordC.mbView, -1, LockC.NO)[0];
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        DumpKeywordList(conn, 0, kw);

        try {
            // --- insert a new list entry ----------------------------------
            kw = conn.ix().checkoutKeywords(new String[] { kwRootId }, KeywordC.mbEdit, 0, LockC.IF_FREE)[0];
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // create new list entry 
        Keyword kwNewChild = new Keyword(); 
        kwNewChild.setText("zero"); 
        kwNewChild.setEnabled(true); 

        // insert list entry at topmost position 
        List<Keyword> lst = new LinkedList<>(Arrays.asList(kw.getChildren())); 
        lst.add(0, kwNewChild); 
        kw.setChildren((Keyword[])lst.toArray()); 

        try {
            // store modified keyword list
            conn.ix().checkinKeywords(new Keyword[] { kw }, LockC.YES);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        try {
            // read keyword list and dump entries
            kw = conn.ix().checkoutKeywords(new String[] { kwRootId }, KeywordC.mbView, -1, LockC.NO)[0];
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        DumpKeywordList(conn, 0, kw);

        try {
            // Beispiel 83: Stichwörter löschen
            
            // delete keyword "two"
            conn.ix().deleteKeywords(new String[] { kw.getChildren()[2].getId() }, LockC.NO);
            kw = conn.ix().checkoutKeywords(new String[] { kwRootId }, KeywordC.mbView, -1, LockC.IF_FREE)[0]; 
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        DumpKeywordList(conn, 0, kw); 

        try {
            // delete entire keyword list
            conn.ix().deleteKeywords(new String[] { kwRootId }, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // throws an Exception 
        try {
            // kw = conn.ix().checkoutKeywords(new String[] { kwRootId }, KeywordC.mbView, -1, LockC.NO)[0];            
            conn.ix().checkoutKeywords(new String[] { kwRootId }, KeywordC.mbView, -1, LockC.NO);            
        } 
        catch (RemoteException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Beispiel 84: Stichwörter mit Platzhaltern verwenden

        // --- create an Access Manager counter ------------------------- 
        CounterInfo ci = new CounterInfo(); 
        ci.setName("kwListCounter"); 
        ci.setValue(123); 
        try {
            conn.ix().checkinCounters(new CounterInfo[] { ci }, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // --- create a keyword list using placeholders ----------------- 

        kwRootId = "MYKEYWORDLIST"; 

        kw = new Keyword(); 
        kw.setId(kwRootId); 

        kw.setChildren(new Keyword[3]); 
        kw.getChildren()[0] = new Keyword(); 
        kw.getChildren()[0].setText("Date " + KeywordC.PLACEHOLDER_DATE); 
        kw.getChildren()[0].setEnabled(true); 
        kw.getChildren()[1] = new Keyword(); 
        kw.getChildren()[1].setText("Username " + KeywordC.PLACEHOLDER_USER_NAME); 
        kw.getChildren()[1].setEnabled(true); 
        kw.getChildren()[2] = new Keyword(); 
        kw.getChildren()[2].setText("Counter " + KeywordC.PLACEHOLDER_COUNTER_BEGIN + ci.getName() + KeywordC.PLACEHOLDER_COUNTER_END); 
        kw.getChildren()[2].setEnabled(true);

        try {
            // store keyword list
            conn.ix().checkinKeywords(new Keyword[] { kw }, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        try {
            // --- dump keyword list in edit and view mode ---------------
            
            // read and dump keyword list in edit mode
            kw = conn.ix().checkoutKeywords(new String[] { kwRootId }, KeywordC.mbEdit, -1, LockC.NO)[0];
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        DumpKeywordList(conn, 0, kw);

        try {
            // read and dump keyword list in view mode
            kw = conn.ix().checkoutKeywords(new String[] { kwRootId }, KeywordC.mbView, -1, LockC.NO)[0];
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        DumpKeywordList(conn, 0, kw);

        // --- use keyword values ------------------------------------ 

        // use date value 
        String kwDateValue = ""; 
        try {
            kwDateValue = conn.ix().cookKeyword(kw.getChildren()[0].getId());
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        System.out.println("kwDateValue=" + kwDateValue); 

        // use user value 
        String kwUserValue = ""; 
        try {
            kwUserValue = conn.ix().cookKeyword(kw.getChildren()[1].getId());
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        System.out.println("kwUserValue=" + kwUserValue); 

        // use counter value 
        for (int i = 0; i < 10; i++) { 
            String kwCounterValue = ""; 
            try {
                kwCounterValue = conn.ix().cookKeyword(kw.getChildren()[2].getId());
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
            System.out.println("kwCounterValue=" + kwCounterValue); // =123+i 
        }

        // Beispiel 85: Verschlagwortungsgeschichte lesen
        ExampleSordHist(conn, parentId);

        // Beispiel 86: Farbe eines Sord-Objektes ändern
        objId = "96502";
        ColorData[] colors = new ColorData[]{};
        try { 
            ed = conn.ix().checkoutSord(objId, EditInfoC.mbOnlyId, LockC.YES);
            colors = conn.ix().checkoutColors(LockC.NO); 
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        for (ColorData color : colors) {
            if (color.getName().toLowerCase().equals("green")) {
                ed.getSord().setKind(color.getId());
                break;
            }
        } 

        // Beispiel 87: Cache aus Color-Objekten erstellen
        Sord[] sords = new Sord[] { ed.getSord() };

        Map<Integer, Color> colorCache = MakeColorCache(conn);            
        
        for (Sord sord1 : sords) { 
            Color color = colorCache.get(0);
            colorCache.getOrDefault(sord1.getKind(), color);            
        }

        try {
            conn.ix().checkinSord(ed.getSord(), new SordZ(SordC.mbKind), LockC.YES);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

    }

    static void BerechtigungenAclItems() {
        // Beispiel 88: Berechtigungsliste ausgeben
        IXConnFactory connFact = new IXConnFactory("http://srvpdevbs01vm:8030/ix-common/ix", "BerechtigungenAclItems", "1.0");
        IXConnection conn = (IXConnection) new Object();
        try {
            conn = connFact.create("Administrator", "ELObs!dev", "localhost", null);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        // IXConnection conn = connFact.create("NormalerUser", "elo", "localhost", null);
        String objId = "96649";

        EditInfoZ editZ = new EditInfoZ(0L, new SordZ(SordC.mbAclItems));
        EditInfo ed = new EditInfo(); 
        try {
            ed = conn.ix().checkoutSord(objId, editZ, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        DumpAcl(ed.getSord().getAclItems());

        // Beispiel 89: ACL zuweisen
        AclItem[] aclItems = new AclItem[2];

        // Everyone group, read access 
        aclItems[0] = new AclItem(); 
        aclItems[0].setType(AclItemC.TYPE_GROUP); 
        aclItems[0].setId(UserInfoC.ID_EVERYONE_GROUP); 
        aclItems[0].setAccess(AccessC.LUR_READ);

        // User Fritz, all access 
        aclItems[1] = new AclItem(); 
        aclItems[1].setType(AclItemC.TYPE_USER); 
        aclItems[1].setName("Fritz"); 
        aclItems[1].setAccess(AccessC.LUR_ALL); 

        ed.getSord().setAclItems(aclItems);
        try {
            conn.ix().checkinSord(ed.getSord(), new SordZ(SordC.mbAclItems), LockC.NO); 
        }
        catch (RemoteException e) {
            e.printStackTrace();
        }

        DumpAcl(ed.getSord().getAclItems());

        // Beispiel 90: Berechtigungslisten vergleichen und kombinieren
        String objId1 = "96649";
        String objId2 = "92233"; 

        // read sords 
        editZ = new EditInfoZ(0L, new SordZ(SordC.mbAclItems)); 
        CombineAclResult res = new CombineAclResult(); 
        try {
            EditInfo ed1 = conn.ix().checkoutSord(objId1, editZ, LockC.NO);
            EditInfo ed2 = conn.ix().checkoutSord(objId2, editZ, LockC.NO);
            // compare acls
            res = conn.ix().combineAcl(ed1.getSord().getAclItems(), ed2.getSord().getAclItems(), null);            
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }


        // print results 
        System.out.println("comparison result:"); 
        System.out.println("are equal=" + (res.getCompareCode() == 0)); 
        System.out.println("equal users,groups,etc=" + (res.getCompareIgnoreAccessCode() == 0)); 
        System.out.println(); 
        System.out.println("intersection (ACL1 AND ACL2):"); 
        DumpAcl(res.getIntersection()); 
        System.out.println(); 
        System.out.println("sum (union) (ACL1 OR ACL2):"); 
        DumpAcl(res.getSum());
        System.out.println(); 
        System.out.println("ACL1 without ACL2 (ACL1 AND NOT ACL2):"); 
        DumpAcl(res.getDifference()); 
        System.out.println(); 
        System.out.println("ACL2 without ACL1 (ACL2 AND NOT ACL1):"); 
        DumpAcl(res.getInverseDifference());

        // Beispiel 91: Zugriffsprüfung auf Workflow-Vorlage
        String flowId = "1847"; 
        WFDiagram wf = new WFDiagram();
        try {
            wf = conn.ix().checkoutWorkFlow(flowId, WFTypeC.TEMPLATE, WFDiagramC.mbAll, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        int access = wf.getAccess(); 
        if ((access & AccessC.LUR_READ) != 0) { 
            System.out.println("read"); 
        } 
        if ((access & AccessC.LUR_WRITE) != 0) { 
            System.out.println("write"); 
        } 
        if ((access & AccessC.LUR_DELETE) != 0) { 
            System.out.println("delete"); 
        }

        // Beispiel 92: Zugriffsprüfung auf ein Sord-Objekt
        access = ed.getSord().getAccess(); 

        if ((access & AccessC.LUR_WRITE) != 0) {
            System.out.println(); 
            if (ed.getSord().getDetails().getArchivingMode() == ArchivingModeC.READONLY) { 
                System.out.println("write ACL only"); 
            } 
            else { 
                System.out.println("write"); 
            } 
        }
    }

    static void SucheNachOrdnernUndDokumenten() {
        IXConnFactory connFact = new IXConnFactory("http://srvpdevbs01vm:8030/ix-common/ix", "SucheNachOrdnernUndDokumenten", "1.0");
        // IXConnection conn = connFact.create("Administrator", "ELObs!dev", "localhost", null);
        IXConnection conn = (IXConnection) new Object();
        try {
            conn = connFact.create("NormalerUser", "elo", "localhost", null);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Beispiel 93: Suche nach Kurzbezeichnung
        FindInfo findInfo = new FindInfo(); 
        findInfo.setFindByIndex(new FindByIndex()); 
        findInfo.getFindByIndex().setName("fritz");

        // Beispiel 94: UND-/ODER-Suche über Kurzbezeichnung
        findInfo = new FindInfo(); 
        findInfo.setFindByIndex(new FindByIndex()); 
        findInfo.getFindByIndex().setName("fritz maria"); 
        findInfo.setFindOptions(new FindOptions()); 
        findInfo.getFindOptions().setSearchMode(SearchModeC.OR);

        // Beispiel 95: UND-/ODER-Suche mit Operatoren in der Kurzbezeichnung
        findInfo = new FindInfo(); 
        findInfo.setFindByIndex(new FindByIndex()); 
        findInfo.getFindByIndex().setName("fritz | maria"); 
        findInfo.setFindOptions(new FindOptions()); 
        findInfo.getFindOptions().setSearchMode(SearchModeC.AND);

        // Beispiel 96: Suche nach komplexem, boolschem Ausdruck
        findInfo = new FindInfo(); 
        findInfo.setFindByIndex(new FindByIndex()); 
        findInfo.getFindByIndex().setName("(fritz | maria) & !paul");

        // Beispiel 97: Suche nach Datumswerten
        findInfo = new FindInfo(); 
        findInfo.setFindByIndex(new FindByIndex()); 
        findInfo.getFindByIndex().setIDateIso("20100112"); 
        findInfo.getFindByIndex().setXDateIso("20100210120000");

        // Beispiel 98: Suche über Datumsbereich
        findInfo = new FindInfo(); 
        findInfo.setFindByIndex(new FindByIndex()); 
        findInfo.getFindByIndex().setIDateIso("200905...201004");

        // Beispiel 99: Suche nach Indexfeld mit Indexgruppe = Wert
        findInfo = new FindInfo(); 
        findInfo.setFindByIndex(new FindByIndex()); 
        findInfo.getFindByIndex().setObjKeys(new ObjKey[] { new ObjKey() }); 
        findInfo.getFindByIndex().getObjKeys()[0].setName("ELOOUTL1"); 
        findInfo.getFindByIndex().getObjKeys()[0].setData(new String[] { "fritz" });

        // Beispiel 100: Suche nach Indexfeld mit Indexwert-ID = Wert
        findInfo = new FindInfo(); 
        findInfo.setFindByIndex(new FindByIndex()); 
        findInfo.getFindByIndex().setObjKeys(new ObjKey[] { new ObjKey() }); 
        findInfo.getFindByIndex().getObjKeys()[0].setId(1); 
        findInfo.getFindByIndex().getObjKeys()[0].setData(new String[] { "fritz" });

        // Beispiel 101: Suche auf Verschlagwortungsmaske eingschränken
        findInfo = new FindInfo(); 
        findInfo.setFindByIndex(new FindByIndex()); 
        findInfo.getFindByIndex().setMaskId("E-Mail");

        // Beispiel 102: Bereichssuche über Indexwerte
        double v1 = 1.1; 
        double v2 = 100.2; 
        String s1 = Integer.toString((int)v1); 
        String s2 = Integer.toString((int)v2); 

        findInfo = new FindInfo(); 
        findInfo.setFindByIndex(new FindByIndex()); 
        findInfo.getFindByIndex().setMaskId("Invoice Form"); 
        findInfo.getFindByIndex().setObjKeys(new ObjKey[] { new ObjKey() }); 
        findInfo.getFindByIndex().getObjKeys()[0].setName("INVOICETOTAL"); 
        findInfo.getFindByIndex().getObjKeys()[0].setData(new String[] { "s1...s2" });

        // Beispiel 103: Suche über Indexwerte außerhalb eines Bereiches
        findInfo = new FindInfo(); 
        findInfo.setFindByIndex(new FindByIndex()); 
        findInfo.getFindByIndex().setMaskId("Invoice Form"); 
        findInfo.getFindByIndex().setObjKeys(new ObjKey[] { new ObjKey() }); 
        findInfo.getFindByIndex().getObjKeys()[0].setName("CUSTOMERID"); 
        findInfo.getFindByIndex().getObjKeys()[0].setData(new String[] { "...3333", "3335..." }); 
        findInfo.setFindOptions(new FindOptions()); 
        findInfo.getFindOptions().setSearchMode(SearchModeC.OR);

        // Beispiel 104: UND-/ODER-Suche über Indexwerte
        findInfo = new FindInfo(); 
        findInfo.setFindByIndex(new FindByIndex()); 
        findInfo.getFindByIndex().setMaskId("E-Mail"); 
        findInfo.getFindByIndex().setObjKeys(new ObjKey[] { new ObjKey() }); 
        findInfo.getFindByIndex().getObjKeys()[0].setName("ELOOUTL1"); 
        findInfo.getFindByIndex().getObjKeys()[0].setData(new String[] { "\"fritz*\" | \"maria*\"" });

        // Beispiel 105: Volltextsuche
        findInfo = new FindInfo();
        findInfo.setFindByFulltext(new FindByFulltext()); 
        findInfo.getFindByFulltext().setTerm("fritz maria");

        // Beispiel 106: Volltextsuche mit iSearch
        findInfo = new FindInfo(); 

        findInfo.setFindDirect(new FindDirect());
        findInfo.getFindDirect().setQuery("maria"); 
        findInfo.getFindDirect().setSearchInFulltext(true); 
        findInfo.getFindDirect().setSearchInIndex(false); 
        findInfo.getFindDirect().setSearchInMemo(false); 
        findInfo.getFindDirect().setSearchInSordName(false); 
        findInfo.getFindDirect().setSearchInVersions(false); 

        int max = 100; 
        int idx = 0; 

        FindResult findResult = null; 

        try { 
            findResult = conn.ix().findFirstSords(findInfo, max, SordC.mbLean);
            while(true) { 
                for (FindByFulltextResultItem resultItem : findResult.getFulltextResultItems()) { 
                    System.out.println(resultItem.getRelevance() + "% " + resultItem.getSord().getName()); 

                    // Summary: hits are enclosed in the HTML 
                    // tags for bold characters: <b> and </b>. 
                    // Here: print 20 chars before and after the first hit. 

                    String summary = resultItem.getSummaryFulltext(); 
                    if (summary.length() != 0) { 
                        int p1 = summary.indexOf("<b>"); 
                        if (p1 < 0) p1 = 0; 
                        int p2 = summary.indexOf("</b>", p1 + 3); 
                        if (p2 < 0) p2 = summary.length() - 20; 

                        if (p1 > 20) p1 -= 20; 
                        if (p2 > 0) p2 += 20; 
                        if (p2 > summary.length()) p2 = summary.length(); 

                        System.out.println(" summary=" + summary.substring(p1, p2 - p1)); 
                    } 
                }

                if (!findResult.isMoreResults()) break;

                idx += findResult.getFulltextResultItems().length; 

                findResult = conn.ix().findNextSords(findResult.getSearchId(), idx, max, SordC.mbLean); 
            } 
        } 
        catch (RemoteException ex) { 
            ex.printStackTrace();
        }        finally { 
            if (findResult != null) { 
                try { 
                    conn.ix().findClose(findResult.getSearchId());
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                }
            } 
        }

        // Beispiel 107: ELO iSearch über Dokumentinhalt und Ablagedatum
        FindDirect findDirect = new FindDirect(); 
        try { 
            findDirect.setQuery("buch " + conn.getCONST().getFIND_DIRECT().getFIELD_IDATE_YEAR() + ":[2009 TO 2011]");
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        findDirect.setSearchInFulltext(true);

        // Beispiel 108: ELO iSearch über Dokumentinhalt und Indexwert
        try {
            DocMask dm = conn.ix().checkoutDocMask(conn.getCONST().getDOC_MASK().getGUID_FOLDER(), DocMaskC.mbAll, LockC.NO);
            findDirect = new FindDirect(); 
            findDirect.setQuery("Geistiges Eigentum " 
                      + conn.getCONST().getFIND_DIRECT().getFIELD_OBJ_KEY()
                      + dm.getLines()[0].getKey() // group name of index value
                      + ":\"zu Guttenberg\""); 
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        findDirect.setSearchInFulltext(true);

        // Beispiel 109: Füllen eines Kontextors
        findInfo = new FindInfo(); 
        findInfo.setFindDirect(new FindDirect());
        findInfo.getFindDirect().setSearchInFulltext(true); 
        findInfo.getFindDirect().setSearchInIndex(true); 
        findInfo.getFindDirect().setSearchInMemo(true); 
        findInfo.getFindDirect().setSearchInSordName(true); 
        findInfo.getFindDirect().setSearchInVersions(true); 

        // findInfo.getFindDirect().setQuery() = "Geistiges Eigentum";
        findInfo.getFindDirect().setQuery("*");

        max = 10; 
        ContextTerm[] terms = new ContextTerm[]{}; 
        try {
            terms = conn.ix().getContextTerms(findInfo, conn.getCONST().getFIND_DIRECT().getFIELD_XDATE_YEAR(), max);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        for (ContextTerm term : terms) {
            System.out.println("term=" + term.getTerm() + ", #=" + term.getDocNum()); 
        }

        // Beispiel 110: Search as You Type
        findInfo = new FindInfo(); 
        findInfo.setFindDirect(new FindDirect()); 
        findInfo.getFindDirect().setSearchInFulltext(true); 
        findInfo.getFindDirect().setSearchInIndex(true); 
        findInfo.getFindDirect().setSearchInMemo(true); 
        findInfo.getFindDirect().setSearchInSordName(true); 
        findInfo.getFindDirect().setSearchInVersions(true); 

        // findInfo.getFindDirect().setQuery() = "Geist";
        findInfo.getFindDirect().setQuery("G");
        String[] terms1 = new String[]{};
        try {
            terms1 = conn.ix().getSearchTerms(findInfo, SearchTermsC.TERMS);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        for (String terms11 : terms1) {
            System.out.println("term=" + terms11);
        }

        // Beispiel 111: Suche nach Randnotizen und Annotations
        findInfo = new FindInfo(); 
        findInfo.setFindByNotes(new FindByNotes()); 
        findInfo.getFindByNotes().setTerm("fritz maria"); 
        findInfo.getFindByNotes().setType(NoteC.TYPE_STAMP);

        // Beispiel 112: Suche über Verschlagwortungsgeschichte
        findInfo = new FindInfo(); 
        findInfo.setFindBySordHist(new FindBySordHist()); 
        SordHistKey hkey = new SordHistKey(); 
        findInfo.getFindBySordHist().setHistKeys(new SordHistKey[] { hkey }); 
        hkey.setKeyName(SordHistKeyC.NAME_SORD_NAME); 
        // hkey.setKeyData("\"fritz*\" | \"maria*\"");
        hkey.setKeyData("\"u*\"");

        // Beispiel 113: Suche über Objekttyp FindInfo
        findInfo = new FindInfo(); 
        findInfo.setFindByType(new FindByType()); 
        findInfo.getFindByType().setTypeExtensions(new String[] { "doc", "xls" });

        // Beispiel 114: Suche auf Ordner einschränken
        findInfo = new FindInfo(); 
        findInfo.setFindByType(new FindByType()); 
        findInfo.getFindByType().setTypeStructures(true); 
        findInfo.getFindByType().setTypeDocuments(false);

        // Beispiel 115: Suche über Versionskommentare
        findInfo = new FindInfo(); 
        findInfo.setFindByVersion(new FindByVersion()); 
        findInfo.getFindByVersion().setVersionNumber("2.*"); 
        findInfo.getFindByVersion().setVersionComment("*Chapter*");

        // Beispiel 115: Suche über MD5-Hash
        findInfo = new FindInfo(); 
        findInfo.setFindByVersion(new FindByVersion()); 
        findInfo.getFindByVersion().setVersionMD5("0570377732E47BC044E7CC8181F6E1ED");

        FindResult fr = new FindResult();
        try {
            fr = conn.ix().findFirstSords(findInfo, 100, SordC.mbMin);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        for (Sord sord : fr.getSords()) {
            System.out.println("sord: " + sord.getId() + " ," + sord.getName());
        }

        // Beispiel 116: Auflisten der Berechtigungen innerhalb eines Ordners
        String arcPath = "ARCPATH:/Tests";
        EditInfo ed = new EditInfo();
        try {
            ed = conn.ix().checkoutSord(arcPath, EditInfoC.mbOnlyId, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        String parentId = ed.getSord().getId() + "";
        findInfo = new FindInfo(); 
        findInfo.setFindChildren(new FindChildren()); 
        findInfo.getFindChildren().setParentId(parentId); 
        findInfo.getFindChildren().setEndLevel(-1); // all subentries 
        findInfo.setFindByAcl(new FindByAcl()); 
        findInfo.getFindByAcl().setDistinctAcl(true); 

        try {
            fr = conn.ix().findFirstSords(findInfo, 1000, SordC.mbMin);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        //while (true)
        //{
            for (Sord sord : fr.getSords()) {
                System.out.println("sord: " + sord.getId() + ", name=" + sord.getName());
                DumpAcl(sord.getAclItems());
            }
        //}

        // Beispiel 117: Bestimmung der Gesamtzahl der Treffer
        findInfo = new FindInfo();
        findInfo.setFindByType(new FindByType());
        findInfo.getFindByType().setTypeStructures(true);
        findInfo.getFindByType().setTypeDocuments(false);

        findInfo.setFindOptions(new FindOptions()); 
        findInfo.getFindOptions().setEvalCount(true);
        try { 
            fr = conn.ix().findFirstSords(findInfo, 10, SordC.mbMin);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        System.out.println("count=" + fr.getCount());

        // Beispiel 118: Sortierung der Suchergebnisse
        findInfo = new FindInfo(); 
        // findInfo.findBy… 
        findInfo.setFindOptions(new FindOptions()); 
        findInfo.getFindOptions().setSortOrder(SortOrderC.IIDATE);

        // Beispiel 119: Sortierung der Suchergebnisse nach Datenbankspalte
        findInfo = new FindInfo(); 
        // findInfo.findBy… 
        findInfo.setFindOptions(new FindOptions()); 
        findInfo.getFindOptions().setOrderBy("objid");

        // Beispiel: Wildcards definieren
        findInfo = new FindInfo(); 
        // findInfo.findBy… 
        findInfo.setFindOptions(new FindOptions()); 
        findInfo.getFindOptions().setWildcards("*?");

        // Beispiel 120: Suchergebnisse auf bestimmte Objekte einschränken
        findInfo = new FindInfo(); 
        // findInfo.findBy… 
        findInfo.setFindOptions(new FindOptions()); 
        findInfo.getFindOptions().setObjIds(new String[] {"123", "234", "789"});

        // Beispiel 121: Mehrere Objekte mit einem Aufruf auslesen
        findInfo = new FindInfo(); 
        findInfo.setFindByIndex(new FindByIndex()); 
        findInfo.getFindByIndex().setName("*"); 
        findInfo.setFindOptions(new FindOptions()); 
        findInfo.getFindOptions().setObjIds(new String[] {"123", "234", "789"});

        // Beispiel 122: Beschränkung der Trefferanzahl aufheben
        findInfo = new FindInfo(); 
        // findInfo.findBy… 
        findInfo.setFindOptions(new FindOptions()); 
        findInfo.getFindOptions().setTotalCount(Integer.MAX_VALUE);
    }

    static void EbenenUndDokumenttypenSordTypes() {
        IXConnFactory connFact = new IXConnFactory("http://srvpdevbs01vm:8030/ix-common/ix", "EbenenUndDokumenttypenSordTypes", "1.0");
        IXConnection conn = (IXConnection) new Object();
        try {
            conn = connFact.create("NormalerUser", "elo", "localhost", null);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Beispiel 124: Ebenen- und Dokumenttypen lesen
        SordType[] sordTypes = new SordType[]{}; 
        try {
            sordTypes = conn.ix().checkoutSordTypes(null, SordTypeC.mbAllJPG, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        for (SordType sordType : sordTypes) { 
            System.out.println("name=" + sordType.getName() + ", id=" + sordType.getId() + ", icon=" + sordType.getIcon().getContentType() + ", #bytes=" + sordType.getIcon().getData().length); 
            boolean isDocNotFolderType; 
            isDocNotFolderType = sordType.getId() >= SordC.LBT_DOCUMENT && sordType.getId() <= SordC.LBT_DOCUMENT_MAX;
            if (isDocNotFolderType) { 
                System.out.print(" extensions="); 
                for (String ext : sordType.getExtensions()) { 
                    System.out.print(ext + ", "); 
                } 
                System.out.println(); 
            }
        }
    }

    static void RandnotizenAnmerkungenStempelUndSchwaerzungen() {

        IXConnFactory connFact = new IXConnFactory("http://srvpdevbs01vm:8030/ix-common/ix", "RandnotizenAnmerkungenStempelUndSchwaerzungen", "1.0");
        IXConnection conn = (IXConnection) new Object();
        try {
            conn = connFact.create("Administrator", "ELObs!dev", "localhost", null);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        String objId = "66314";

        // Indexserver Url

        // Beispiel 126: Randnotizen und Attachments lesen
        Note[] notes = new Note[]{}; 
        try {
            notes = conn.ix().checkoutNotes(objId, null, NoteC.mbAll, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        for (Note note : notes) { 
            System.out.println("note.getId()=" + note.getId() + ", note.getType()=" + note.getType()); 
            String text = note.getDesc(); 
            if (note.getNoteText() != null) text = note.getNoteText().getText(); 
            if (note.getNoteFreehand() != null) text = "-freehand- no text"; 
            if (note.getNoteImage() != null) text = "-image- no text"; 
            System.out.println(" note.getText()=" + text); 
        } 

        EditInfoZ editZ = new EditInfoZ(EditInfoC.mbNoteMembers, null); 
        EditInfo ed = new EditInfo(); 
        try {
            ed = conn.ix().checkoutSord(objId, editZ, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        for (Note note : ed.getNotes()) {
            
        }
        objId = "99157";

        // Beispiel 127: Randnotiz anlegen
        Note publicNote = new Note(); 
        try {
            publicNote = conn.ix().createNote2(objId, NoteC.TYPE_NORMAL, "");
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        publicNote.setDesc("Public note"); 

        Note privateNote = new Note(); 
        try {
            privateNote = conn.ix().createNote2(objId, NoteC.TYPE_PERSONAL, "");
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        privateNote.setDesc("Private note"); 

        Note stampNote = new Note(); 
        try {
            stampNote = conn.ix().createNote2(objId, NoteC.TYPE_STAMP, "");
        } catch (RemoteException ex) {
            ex.printStackTrace();            
        }
        stampNote.setDesc("Stamp"); 

        notes = new Note[] { publicNote, privateNote, stampNote }; 
        int[] noteIds = new int[]{}; 
        try {
            noteIds = conn.ix().checkinNotes(objId, notes, NoteC.mbAll, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < noteIds.length; i++) { 
            notes[i].setId(noteIds[i]); 
            System.out.println("Created note.getId()=" + notes[i].getId() + ", desc=" + notes[i].getDesc()); 
        }

        // Beispiel 128: Textbox-Anmerkung anlegen
        Note annNote = new Note();
        try {
            annNote = conn.ix().createNote2(objId, NoteC.TYPE_ANNOTATION_NOTE_WITHFONT, "");
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        annNote.getNoteText().setText("TYPE\n\nANNOTATION NOTE WITHFONT");

        annNote.setXPos(200);
        annNote.setYPos(100);
        annNote.setWidth(200);
        annNote.setHeight(200);

        annNote.setColor(0xFFFE00); // red=0, green=254, blue=255 

        annNote.getNoteText().getFontInfo().setFaceName("Courier");
        annNote.getNoteText().getFontInfo().setItalic(true);

        try {
            conn.ix().checkinNotes(objId, new Note[] { annNote }, NoteC.mbAll, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Beispiel 129: Text-Anmerkung anlegen
        Note annTextNote = new Note();
        try {
            annTextNote = conn.ix().createNote2(objId, NoteC.TYPE_ANNOTATION_TEXT, "");
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        annTextNote.getNoteText().setText("Text without background");

        annTextNote.setXPos(200);
        annTextNote.setYPos(100);
        annTextNote.setWidth(500);
        annTextNote.setHeight(200);

        annTextNote.getNoteText().getFontInfo().setFaceName("Arial");
        annTextNote.getNoteText().getFontInfo().setHeight(20);

        try {
            conn.ix().checkinNotes(objId, new Note[] { annTextNote }, NoteC.mbAll, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Beispiel 132: Horizontale Linie anlegen
        Note hline = new Note(); 
        try {
            hline = conn.ix().createNote2(objId, NoteC.TYPE_ANNOTATION_HORIZONTAL_LINE, "");
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        PointInfo p1 = new PointInfo(); 
        p1.setX(60); 
        p1.setY(200); 
        PointInfo p2 = new PointInfo(); 
        p2.setX(260); 
        p2.setY(p1.getY());

        hline.getNoteFreehand().setPoints(new PointInfo[] { p1, p2 });
        hline.getNoteFreehand().setWidth(20);

        hline.setColor(0xC1FFC2); // red=0xC2, green=0xFF, blue=0xC1 
        try {
            conn.ix().checkinNotes(objId, new Note[] { hline }, NoteC.mbAll, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Beispiel 130: Horizontale Überdeckungslinie anlegen
        objId = "99172";
        try { 
            hline = conn.ix().createNote2(objId, NoteC.TYPE_ANNOTATION_STRIKEOUT, "");
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        p1 = new PointInfo(); 
        p1.setX(60); 
        p1.setY(200); 
        p2 = new PointInfo(); 
        p2.setX(260); 
        p2.setY(p1.getY());

        hline.getNoteFreehand().setPoints(new PointInfo[] { p1, p2 });
        hline.getNoteFreehand().setWidth(90);
        hline.getNoteFreehand().setStrikeoutWidth(30);

        hline.setColor(0x80FFFF); // red=0xFF, green=0xFF, blue=0x80 
        try {
            conn.ix().checkinNotes(objId, new Note[] { hline }, NoteC.mbAll, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Beispiel 131: Freihandlinie anlegen
        objId = "99174";
        Note fline = new Note(); 
        try {
            fline = conn.ix().createNote2(objId, NoteC.TYPE_ANNOTATION_FREEHAND, "");
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        List<PointInfo> points = new LinkedList<>(); 
        for (int i = 0; i < 360; i += 5) { 
            if (i >= NoteFreehandC.MAX_POINTS) break; 
            double alpha = 2 * Math.PI * (double)i / 360.0; 
            PointInfo p = new PointInfo(); 
            p.setX(150 + (int)(Math.sin(alpha) * 100)); 
            p.setY(200 + (int)(Math.cos(alpha) * 30)); 
            points.add(p); 
        }
        fline.getNoteFreehand().setPoints((PointInfo[])points.toArray());
        fline.getNoteFreehand().setWidth(10);

        fline.setColor(0xC1FFC2); // red=0xC2, green=0xFF, blue=0xC1 
        try {
            conn.ix().checkinNotes(objId, new Note[] { fline }, NoteC.mbAll, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Beispiel 132: Markierungsrechteck einfügen
        objId = "99328";

        Note rect = new Note();
        try {
            rect = conn.ix().createNote2(objId, NoteC.TYPE_ANNOTATION_MARKER, "");
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        rect.setXPos(60);
        rect.setYPos(170);
        rect.setWidth(300);
        rect.setHeight(50);

        rect.setColor(0xC1FFC2); // red=0xC2, green=0xFF, blue=0xC1 
        try {
            conn.ix().checkinNotes(objId, new Note[] { rect }, NoteC.mbAll, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Beispiel 133: Anmerkung mit Berechtigungsliste
        Note rectacl = new Note();
        try {
            rectacl = conn.ix().createNote2(objId, NoteC.TYPE_ANNOTATION_TEXT, "");
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        rectacl.getNoteText().setText("Text without background");

        rectacl.setXPos(200);
        rectacl.setYPos(100);
        rectacl.setWidth(500);
        rectacl.setHeight(200);

        rectacl.setAclItems(new AclItem[] { new AclItem(), new AclItem() });
        rectacl.getAclItems()[0].setType(AclItemC.TYPE_USER);
        rectacl.getAclItems()[0].setName(conn.getUserName());
        rectacl.getAclItems()[0].setAccess(AccessC.LUR_ALL);
        rectacl.getAclItems()[1].setType(AclItemC.TYPE_GROUP);
        rectacl.getAclItems()[1].setId(UserInfoC.ID_EVERYONE_GROUP);
        rectacl.getAclItems()[1].setAccess(AccessC.LUR_READ);

        try {
            conn.ix().checkinNotes(objId, new Note[] { rectacl }, NoteC.mbAll, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Beispiel 134: Schwärzung anlegen
        Note black = new Note();
        try {
            black = conn.ix().createNote2(objId, NoteC.TYPE_ANNOTATION_MARKER, "");
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        /*
        black.setXPos() = 100;
        black.setYPos() = 1378;
        black.setWidth() = 1039;
        black.setHeight() = 110;
        */
        black.setXPos(200);
        black.setYPos(100);
        black.setWidth(500);
        black.setHeight(200);

        black.setAclItems(new AclItem[] { new AclItem() });
        black.getAclItems()[0].setType(AclItemC.TYPE_USER);
        black.getAclItems()[0].setName(conn.getUserName());
        black.getAclItems()[0].setAccess(AccessC.LUR_ALL);

        black.setColor(NoteC.COLOR_ANNOTATION_MARKER_DM);

        try {
            conn.ix().checkinNotes(objId, new Note[] { black }, NoteC.mbAll, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Beispiel 135: Stempeldefinition für einen Bildstempel anlegen
        String fileDir = "E:\\Temp\\";
        String fileName = "user.jpg";

        NoteTemplate noteTemplate = new NoteTemplate(); 
        try {
            noteTemplate = conn.ix().createNoteTemplate(NoteTemplateC.USERID_ALL);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        noteTemplate.setName("Image Stamp"); 

        noteTemplate.setNoteImage(new NoteImage()); 
        noteTemplate.getNoteImage().setFileName(fileName); // without directory 
        noteTemplate.getNoteImage().setFileData(new FileData()); 
        noteTemplate.getNoteImage().getFileData().setContentType("image/jpg");
        
        File filePath = new File(fileDir + fileName);
        byte[] data = new byte[(int) filePath.length()];
        try (InputStream is = new FileInputStream(filePath)) {
            is.read(data);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        noteTemplate.getNoteImage().getFileData().setData(data);

        try {
            noteTemplate.setId(conn.ix().checkinNoteTemplates(new NoteTemplate[] { noteTemplate }, NoteTemplateC.mbAll, LockC.NO)[0]);
            System.out.println("created note template, id=" + noteTemplate.getId());            
        }
        catch (RemoteException e){ 
            e.printStackTrace();
        }

        try {
            // Beispiel 136: Stempeldefinition für einen Textstempel
            noteTemplate = conn.ix().createNoteTemplate(NoteTemplateC.USERID_ALL);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        noteTemplate.setName("Text Stamp"); 

        noteTemplate.setNoteText(new NoteText()); 
        noteTemplate.getNoteText().setText(NoteTemplateC.PLACEHOLDER_DATE + " " + NoteTemplateC.PLACEHOLDER_TIME); 

        noteTemplate.getNoteText().setFontInfo(new FontInfo()); 
        noteTemplate.getNoteText().getFontInfo().setFaceName("Arial"); 
        noteTemplate.getNoteText().getFontInfo().setHeight(24); 
        noteTemplate.getNoteText().getFontInfo().setBold(true);

        try {
            noteTemplate.setId(conn.ix().checkinNoteTemplates(new NoteTemplate[] { noteTemplate }, NoteTemplateC.mbAll, LockC.NO)[0]);
            System.out.println("created note template, id=" + noteTemplate.getId());
        }
        catch (RemoteException e) {
            e.printStackTrace();
        }

        // Beispiel 137: Verfügbare Stempel auflisten
        NoteTemplate[] noteTemplates = new NoteTemplate[]{}; 
        try {
            noteTemplates = conn.ix().checkoutNoteTemplates("", null, NoteTemplateC.mbMin, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        for (NoteTemplate noteTemplate1 : noteTemplates) {
            System.out.println("name=" + noteTemplate1.getName()); 
            if (noteTemplate1.getNoteImage() != null) { 
                System.out.println(" image=" + noteTemplate1.getNoteImage().getFileName()); 
            }
            else if (noteTemplate1.getNoteText() != null) {
                System.out.println(" text=" + noteTemplate1.getNoteText().getText());
            }
        }

        // Beispiel 138: Stempeldefinition löschen
        try {
            noteTemplate = conn.ix().checkoutNoteTemplates(NoteTemplateC.USERID_ALL, new String[] { "Date+Time Stamp" }, NoteTemplateC.mbMin, LockC.NO)[0];
            conn.ix().deleteNoteTemplates(NoteTemplateC.USERID_ALL, new String[] { Integer.toString(noteTemplate.getId()) }, LockC.NO);
        }
        catch (RemoteException e){
            e.printStackTrace();
        }

        // Beispiel 139: Stempel aufbringen
        Note note1 = new Note(); 
        try {
            note1 = conn.ix().createNote2(objId, NoteC.TYPE_ANNOTATION_TEXT, "Image Stamp");
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        note1.setXPos(5);
        note1.setYPos(5); 
        try {
            conn.ix().checkinNotes(objId, new Note[] { note1 }, NoteC.mbAll, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

    static void Workflows() {
        IXConnFactory connFact = new IXConnFactory("http://srvpdevbs01vm:8030/ix-common/ix", "Workflows", "1.0");
        IXConnection conn = (IXConnection) new Object();
        try {
            conn = connFact.create("Administrator", "ELObs!dev", "localhost", null);
            // IXConnection conn = connFact.create("NormalerUser", "elo", "localhost", null);
            // IXConnection conn = connFact.create("Unittest", "elo", "localhost", null);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Beispiel 140: Ad-hoc-Workflow starten, parallel, Zur Kenntnisnahme
        String objId = "99328";
        /*
        int wfId1 = conn.ix().startAdHocWorkFlow( "Adhoc Workflow, parallel, fyi", objId, 
                                                new String[] { "Fritz", "Ruberg" }, 
                                                "Programming Manual", 
                                                false, // forValidation = false 
                                                false, // serialFlow = false 
                                                conn.getUserName(), "Workflow canceled", 
                                                conn.getUserName(), "Workflow finished", 
                                                "");
        */
        // Beispiel 141: Ad-hoc-Workflow starten, parallel, Zur Freigabe
        /*
        int wfId2 = conn.ix().startAdHocWorkFlow( "Adhoc Workflow, parallel, validation", objId,
                                                new String[] { "Fritz", "Ruberg" },
                                                "Programming Manual", 
                                                true, // forValidation = true 
                                                false, // serialFlow = false 
                                                conn.getUserName(), "Workflow canceled", 
                                                conn.getUserName(), "Workflow finished", "");
        */
        //Beispiel 142: Ad-hoc-Workflow starten, seriell, Zur Kenntnisnahme
        /*
        int wfId3 = conn.ix().startAdHocWorkFlow( "Adhoc Workflow, serial, fyi", objId,
                    new String[] { "Fritz", "Ruberg" }, 
                    "Programming Manual", 
                    false, // forValidation = false 
                    true, // serialFlow = true 
                    conn.getUserName(), "Workflow canceled", 
                    conn.getUserName(), "Workflow finished", "");
        */
        // Beispiel 143: Ad-hoc-Workflow starten, seriell, Zur Freigabe
        /*
        int wfId4 = conn.ix().startAdHocWorkFlow( "Adhoc Workflow, serial, validation", objId,
                    new String[] { "Fritz", "Ruberg" }, 
                    "Programming Manual", 
                    true, // forValidation = true 
                    true, // serialFlow = true 
                    conn.getUserName(), "Workflow canceled", 
                    conn.getUserName(), "Workflow finished", "");
        */ 
        // Beispiel 144: Standard-Workflow starten            
        /*
        String workflowTemplate = "Test";
        int wfId = conn.ix().startWorkFlow(workflowTemplate, "Hotel Reservation for " + objId, objId);
        */
        // Beispiel 145: Selbstdefinierten Workflow starten
        // read workflow template 
        String workflowTemplate = "Test";
        WFDiagram wf = new WFDiagram();
        try {
            wf = conn.ix().checkoutWorkFlow(workflowTemplate, 
                    WFTypeC.TEMPLATE,
                    WFDiagramC.mbAll,
                    LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // convert to active workflow 
        wf.setType(WFTypeC.ACTIVE); 

        // mark as new workflow 
        wf.setId(-1); 

        // assign a workflow name 
        wf.setName("Hotel Reservation for " + objId); 

        // assign an object ID 
        wf.setObjId(objId);

        try {
            // checkin and start
            conn.ix().checkinWorkFlow(wf, WFDiagramC.mbAll, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Beispiel 146: Eigene Workflowaufgaben sammeln
        FindTasksInfo findInfo = new FindTasksInfo(); 
        findInfo.setInclWorkflows(true); 
        findInfo.setInclGroup(true); 
        findInfo.setInclDeputy(true); 
        findInfo.setLowestPriority(UserTaskPriorityC.LOWEST); 
        findInfo.setLowestPriority(UserTaskPriorityC.HIGHEST); 

        FindResult findResult = null;
        try { 
            int idx = 0; 
            int max = 1000; 

            findResult = conn.ix().findFirstTasks(findInfo, max); 
            while (true) { 
                for (UserTask task : findResult.getTasks()) {
                    WFCollectNode wfNode = task.getWfNode();
                    System.out.println("flowId=" + wfNode.getFlowId() +
                            ", nodeId=" + wfNode.getNodeId() +
                            ", task name=" + wfNode.getNodeName() +
                            ", sord.getName()=" + wfNode.getObjName());
                    System.out.println("task name=" + wfNode.getNodeName() +
                            ", sord.getName()=" + wfNode.getObjName());
                    if (wfNode.getTimeLimitIso().length() != 0) {
                        System.out.println( " time limit=" +
                                conn.isoToDate(wfNode.getTimeLimitIso())); 
                    }
                    if (wfNode.isOverTimeLimit()) {
                        System.out.println(" over time");
                    }
                } 

                if (!findResult.isMoreResults()) break; 

                idx += findResult.getTasks().length; 
                findResult = conn.ix().findNextTasks(findResult.getSearchId(), idx, max); 
            } 
        }
        catch (RemoteException ex) { 
            ex.printStackTrace();
        }        
        finally { 
            if (findResult != null) 
            { 
                try { 
                    conn.ix().findClose(findResult.getSearchId());
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                }
            } 
        }

        // Beispiel 147: Weiterleiten einer Workflowaufgabe
        /*
        int flowId = wfId;
        int nodeId = 1;

        WFEditNode editNode = conn.ix().beginEditWorkFlowNode(flowId, nodeId, LockC.YES); 

        System.out.println("node.getName()=" + editNode.node.getName()); 
        System.out.println("node.getDesc()=" + editNode.node.getVersion()); 
        if ((editNode.node.flags & WFNodeC.FLAG_ONE_SUCCESSOR) != 0) 
        { 
            System.out.println("only one successor"); 
        } 
        foreach (WFNode succNode in editNode.succNodes) 
        { 
            System.out.println("succNode.getId()=" + succNode.getId() + ", .userName=" + succNode.userName + ", .getName()=" + succNode.getName()); 
        }

        // show dialog 
        bool ok = true; // OK pressed 
        int[] succNodeIds = new int[] {2}; // selected successor node IDs 

        conn.ix().endEditWorkFlowNode(flowId, nodeId, 
            false, // do not terminate 
            !ok, // dialog canceled 
            editNode.node.getName(), // maybe modified node name 
            "Some text", // node comment 
            succNodeIds); // successor node IDs
        */
        // Beispiel 148: Workflowaufgabe annehmen
        /*
        conn.ix().takeWorkFlowNode(flowId, nodeId, "", WFTakeNodeC.RESET_IN_USE_DATE, LockC.IF_FREE);
        */

        // Beispiel 149: Workflowaufgabe mit dem Indexserver delegieren
        WFDelegateNodeInfo delegateInfo = new WFDelegateNodeInfo(); 
        /*
        delegateInfo.getFlowId() = "One User Workflow"; 
        delegateInfo.getNodeId() = 1; 
        delegateInfo.delegateToUserId = "Maria"; 
        delegateInfo.delegateNodeName = "Node 1 for Maria";
        */
        /*
        delegateInfo.getFlowId() = wfId.ToString();
        delegateInfo.getNodeId() = 1;
        delegateInfo.delegateToUserId = "Ruberg";
        delegateInfo.delegateNodeName = "Node 1 for Ruberg"; 

        delegateInfo.delegateNodeMoveX = 200; 
        conn.ix().delegateWorkFlowNode(delegateInfo, LockC.IF_FREE);
        */

        // Beispiel 150: Workflowaufgabe mit dem Indexserver delegieren, Rückführung einfügen
        /*
        delegateInfo.getFlowId() = "One User Workflow"; 
        delegateInfo.getNodeId() = 1; 
        delegateInfo.delegateToUserId = "Maria"; 
        delegateInfo.delegateNodeName = "Node 1 for Maria"; 
        delegateInfo.delegateNodeMoveX = 200; delegateInfo.backNodeName = "Node 1 back";
        */
        /*
        delegateInfo.getFlowId() = wfId.ToString();
        delegateInfo.getNodeId() = 1;
        delegateInfo.delegateToUserId = "Ruberg";
        delegateInfo.delegateNodeName = "Node 1 for Ruberg";
        delegateInfo.delegateNodeMoveX = 200; delegateInfo.backNodeName = "Node 1 back"; 

        delegateInfo.backNodeMoveX = 400;
        conn.ix().delegateWorkFlowNode(delegateInfo, LockC.IF_FREE);
        */
        // Beispiel 151: Workflowaufgabe zurückstellen
        /*
        Date deferDate = Date.Now; 
        deferDate = deferDate.AddDays(2); 
        String deferDateIso = conn.DateToIso(deferDate); 
        // conn.ix().deferWorkFlowNode("One user workflow", 1, deferDateIso, LockC.NO);
        conn.ix().deferWorkFlowNode(wfId.ToString(), 1, deferDateIso, LockC.NO);
        */
        // Beispiel 152: Workflow abbrechen
        // conn.ix().getTerm()inateWorkFlow("One User Workflow", LockC.FORCE);
        /*
        conn.ix().getTerm()inateWorkFlow(wfId.ToString(), LockC.FORCE);
        */

        // Beispiel 153: Aktive und abgeschlossene Workflows auflisten
        /*
        FindWorkflowInfo findWfInfo = new FindWorkflowInfo(); 
        findWfInfo.getType() = WFTypeC.ACTIVE;
        FindWfLoop(conn, findWfInfo);

        findWfInfo = new FindWorkflowInfo();
        findWfInfo.getType() = WFTypeC.FINISHED;
        FindWfLoop(conn, findWfInfo);
        */
        // Beispiel 154: Workflows eines beteiligten Anwenders auflisten
        /*
        FindWorkflowInfo findWfInfo = new FindWorkflowInfo();
        findWfInfo.getType() = WFTypeC.ACTIVE;
        // findWfInfo.userIds = new String[] { "Fritz" };
        findWfInfo.userIds = new String[] { "Ruberg" };
        FindWfLoop(conn, findWfInfo);
        */

        //Beispiel 155: Workflows von Mitgliedern einer Gruppe
        /*
        FindWorkflowInfo findWfInfo = new FindWorkflowInfo();
        int groupId = UserInfoC.ID_EVERYONE_GROUP;    
        UserName[] userNames = conn.ix().getUserNames(new String[] { Integer.toString(groupId) }, 
                                                    CheckoutUsersC.MEMBERS_OF_GROUP_RECURSIVE);

        findWfInfo.userIds = new String[userNames.length];
        for (int i = 0; i < findWfInfo.userIds.length; i++) 
        {
            findWfInfo.userIds[i] = userNames[i].getName(); 
        }
        FindWfLoop(conn, findWfInfo);
        */

        // Beispiel 156: Workflows für aktive Anwender
        /*
        FindWorkflowInfo findWfInfo = new FindWorkflowInfo();
        findWfInfo.getType() = WFTypeC.ACTIVE;
        findWfInfo.activeUserIds = new String[] { "Ruberg" };
        FindWfLoop(conn, findWfInfo);
        */

        // Beispiel 157: Workflows zu einem Objekt auflisten
        /*
        FindWorkflowInfo findWfInfo = new FindWorkflowInfo();
        findWfInfo.getType() = WFTypeC.ACTIVE;
        findWfInfo.getObjId() = "ARCPATH:/Tests/Test Jan";
        FindWfLoop(conn, findWfInfo);
        */

        // Beispiel 158: Workflows mit Fristüberschreitung auflisten
        FindWorkflowInfo findWfInfo = new FindWorkflowInfo(); 
        findWfInfo.setType(WFTypeC.ACTIVE);
        findWfInfo.setOverTimeLimit(true);
        FindWfLoop(conn, findWfInfo);

        try {
            // Beispiel 159: Einfache Workflow-Vorlage erstellen
            // Initialize workflow object.
            wf = conn.ix().createWorkFlow("Simple Workflow", WFTypeC.TEMPLATE);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // ---- Create the workflow nodes ------- 

        // Create an array to store the workflow nodes 
        wf.setNodes(new WFNode[2]);

        try {
            // Create the start node
            wf.getNodes()[0] = conn.ix().createWFNode(0, WFNodeC.TYPE_BEGINNODE);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        wf.getNodes()[0].setName("Start node"); 

        try {
            // Create a person node.
            // Here: a task for the user that starts the workflow
            wf.getNodes()[1] = conn.ix().createWFNode(1, WFNodeC.TYPE_PERSONNODE);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        wf.getNodes()[1].setName("Todo"); 
        wf.getNodes()[1].setUserId(WFNodeC.USERID_OWNER); 

        // ---- Create the workflow node associations ------- 

        // Create matrix and array to hold the associations 
        wf.setMatrix(new WFNodeMatrix()); 
        wf.getMatrix().setAssocs(new WFNodeAssoc[1]); 

        // Connect start node to person node 
        wf.getMatrix().getAssocs()[0] = new WFNodeAssoc(); 
        wf.getMatrix().getAssocs()[0].setNodeFrom(0); // == wf.getNodes()[0].getId(); 
        wf.getMatrix().getAssocs()[0].setNodeTo(1); // == wf.getNodes()[1].getId();

        // ---- Store the new workflow --------------------- 
        try {
            wf.setId(conn.ix().checkinWorkFlow(wf, WFDiagramC.mbAll, LockC.NO)); 
        }
        catch (RemoteException e) { 
            e.printStackTrace();
        }

        System.out.println("Created new workflow template, id=" + wf.getId());

        // Beispiel 160: Ausdrücke für die Bedingung im Entscheidungsknoten
        WFNode node = new WFNode();

        // Text comparison 
        node.setYesNoCondition("ELO_WF_STATUS=terminate"); 

        // Numeric comparison 
        node.setYesNoCondition("AMOUNT>=10.30"); 

        // Text comparison is valid for ISO date values too 
        node.setYesNoCondition("SAPCREATEDATE>=20100706");

        // Beispiel 161: Beispiel eines Zyklusskripts
        /*
        function onEnterNode(ci, userId, workflow, nodeId) { 

            var editInfo = ix.checkoutSord(ci, workflow.getObjId(), CONST.EDIT_INFO.mbSord, CONST.LOCK.YES); 
            var repeat = (editInfo.getSord().getDesc().getIndex()Of("repeat") >= 0) ? true : false; 
            return repeat; 
        }
        */
        // Beispiel 162a: Workflow exportieren
        String fileName = "E:\\Temp\\wf.txt";
        WorkflowExportOptions wfOpt = new WorkflowExportOptions();
        wfOpt.setFlowId("Simple Workflow");
        FileData fd = new FileData();
        try {
            fd = conn.ix().exportWorkflow(wfOpt);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        byte[] data = fd.getData();
        try (OutputStream os = new FileOutputStream(fileName)) {
            os.write(data);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        // Beispiel 162: Workflow importieren
        data = new byte[(int) new File(fileName).length()];
        try (InputStream is = new FileInputStream(fileName)) {
            is.read(data);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        try {
            int wfId = conn.ix().importWorkFlow("abc", data);
            wf = conn.ix().checkoutWorkFlow("" + wfId, WFTypeC.TEMPLATE, WFDiagramC.mbAll, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }


        // Beispiel 163: Workflow-Vorlage löschen
        // conn.ix().deleteWorkFlow("abc", WFTypeC.TEMPLATE, LockC.NO);

        // Beispiel 164: Workflow-Version erstellen
        wf.setVersion(new WFVersion()); 
        wf.getVersion().setId(-1); // create new version 
        wf.getVersion().setVersion("1.0"); 
        wf.getVersion().setVersion("My comment"); 
        int[] wfIds = new int[]{}; 
        try {
            wfIds = conn.ix().checkinWorkflowTemplate(wf, WFDiagramC.mbAll, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        System.out.println("workflow.getId()=" + wfIds[0] + ", version.getId()=" + wfIds[1]);

        // Beispiel 165: Workflow-Versionen auflisten
        FindWFVersion(conn, "abc");

        // Beispiel 166: Arbeitsversion einer Workflow-Vorlage setzen
        String flowId = "abc";
        WFDiagram wfOld = new WFDiagram(); 
        WFDiagram wfNew = new WFDiagram();
        try {
            wfOld = conn.ix().checkoutWorkflowTemplate(flowId, "", WFDiagramC.mbAll, LockC.NO);
            wfNew = conn.ix().checkoutWorkflowTemplate(flowId, "1", WFDiagramC.mbAll, LockC.NO); 
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // save old work version 
        wfOld.getVersion().setId(-1); 
        try { 
            conn.ix().checkinWorkflowTemplate(wfOld, WFDiagramC.mbAll, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // assign new work version 
        wfNew.getVersion().setId(0);
        try {
            conn.ix().checkinWorkflowTemplate(wfNew, WFDiagramC.mbAll, LockC.NO);
            
            // Beispiel 167: Definition der Funktionen onEnterNode und onExitNode
            /**
             * Indexserver calls this function if a workflow node is activated
             * @param ci ClientInfo object with language, country and ticket
             * @param userId The calling users ID (Integer)
             * @param workflow WFDiagram object
             * @param nodeId The activated node ID (Integer)
             * @return Cycle nodes: true, to repeat the cycle.
             */
            // function onEnterNode(ci, userId, workflow, nodeId) {
            // }
            
            /**
             * Indexserver calls this function if a workflow node is
             * deactivated
             * @param ci ClientInfo object with language, country and ticket
             * @param userId The calling users ID (Integer) *
             * @param workflow WFDiagram object
             * @param nodeId The activated node ID (Integer)
             */
            // function onExitNode(ci, userId, workflow, nodeId) {
            // }
            
            // Beispiel 168: Verschlagwortungsdaten im Skript ändern
            /*
            function onEnterNode(ci, userId, workflow, nodeId) {
            var ed = ix.checkoutSord(ci, workflow.getObjId(), CONST.EDIT_INFO.mbSord, CONST.LOCK.YES);
            ed.getSord().getDesc() = "This text was written inside the Script";
            ix.checkinSord(ci, ed.getSord(), CONST.SORD.mbAll, CONST.LOCK.YES);
            }
            */
            
            // Beispiel 169: Dokumentzuordnung im Workflow-Skript ändern
            /*
            function onExitNode(ci, userId, workflow, nodeId) {
            if (log.isDebugEnabled()) log.debug("onExitNode(");
            
            var ed = ix.checkoutSord(ci, workflow.getObjId(), CONST.EDIT_INFO.mbSord, CONST.LOCK.YES);
            
            // new object ID is found in sord.getDesc()
            var newObjId = ed.getSord().getDesc();
            workflow.getObjId()=newObjId;
            if (log.isDebugEnabled()) log.debug("new wf.getObjId()=" + newObjId);
            
            // update internal workflow data
            workflow.dbHelper.updateDisplayMembers(true);
            
            if (log.isDebugEnabled()) log.debug(")onExitNode");
            }
            */
            
            // Beispiel 170: Anwender und Datumsangaben im Skript ändern
            /*
            function onExitNode(ci, userId, workflow, nodeId) {
            workflow.getNodes()[2].userName = "Maria";
            workflow.getNodes()[2].userDelayDateIso = "20091211100908";
            workflow.dbHelper.updateDisplayMembers(true);
            }
            */
            
            // Beispiel 171: Knoten im Skript aktivieren
            /*
            function onExitNode(ci, userId, workflow, nodeId) {
            for (var i = 0; i < workflow.getNodes().length; i++) {
            var node = workflow.getNodes()[i];
            if (node.getName() == "Invocie accepted") {
            node.isNext = 1;
            break;
            }
            }
            }
            */
            
            // Beispiel 172: Workflow-Skript zum Einfügen eines Knotens
            /*
            function onExitNode(ci, userId, workflow, nodeId) {
            if (log.isDebugEnabled()) log.debug("onExitNode(");
            
            // (1) Initialize a new node object
            var node = ix.createWFNode(ci, 0, Packages.de.elo.ix.client.WFNodeC.TYPE_PERSONNODE);
            node.getName() = "New"; node.userName = "Administrator";
            
            // (2) Place the new node to the right of the dummy node.
            var dummyNode = getNode(workflow, 2);
            node.posX = dummyNode.posX + 200;
            node.posY = dummyNode.posY;
            
            // (3) Add the node (node.getId() is set)
            addNode(workflow, node);
            
            // (4) Remove the association from "Dummy" to "End"
            removeAssoc(workflow, 2, 3);
            
            // (5) Add an association from "Dummy" to "New"
            addAssoc(workflow, 2, node.getId());
            
            // (6) Add an association from "New" to "End"
            addAssoc(workflow, node.getId(), 3);
            
            // (7) Update internal helper objects
            workflow.dbHelper.updateDisplayMembers(true);
            
            if (log.isDebugEnabled()) log.debug(")onExitNode");
            }
            */
            
            // Beispiel 173: Skriptfunktion getNode liefert Knotenobjekt zu gegebener ID
            
            /**
             * Return the node object with the given ID.
             * @param workflow WFDiagram object
             * @param nodeId ID of the workflow node
             * @return node object
             * @throws Exception, if node does not exist.
             */
            /*
            function getNode(workflow, nodeId) {
            for (var i = 0; i < workflow.getNodes().length; i++) {
            var node = workflow.getNodes()[i];
            if (node.getId() == nodeId) {
            return node;
            }
            }
            throw "WFScript: nodeId=" + nodeId + " not found in workflow.getId()=" + workflow.getId() + ", .getName()=" + workflow.getName();
            }
            */
            
            // Beispiel 174: Skriptfunktion zum Erweitern des Arrays WFDiagram.getNodes()
            
            /**
             * Adds a node to the workflow.
             * Assigns a unique node ID.
             * @param workflow WFDiagram object
             * @param node Node object
             */
            /*
            function addNode(workflow, node) {
            if (log.isDebugEnabled()) log.debug("addNode(");
            
            // Copy workflow nodes to JavaScript array
            var jsnodes = [];
            for (var i = 0; i < workflow.getNodes().length; i++) {
            jsnodes.push(workflow.getNodes()[i]);
            }
            
            // Compute the maximum node ID
            var maxId = 1;
            for (var i = 0; i < jsnodes.length; i++) {
            if (jsnodes[i].getId() > maxId) {
            maxId = jsnodes[i].getId();
            }
            }
            
            // Assign unique node ID: max+1
            node.getId() = maxId + 1;
            if (log.isDebugEnabled()) log.debug("node=" + node);
            
            // Add node to JavaScript array
            jsnodes.push(node);
            
            // Convert JavaScript array to Java array
            workflow.getNodes() = jsnodes;
            
            if (log.isDebugEnabled()) log.debug(")addNode");
            }
            */
            
            // Beispiel 175: Skriptfunktion zum Löschen einer Knotenverbindung
            
            /**
             * Remove the given association from the node matrix.
             * @param workflow WFDiagram object
             * @param fromId ID of the source node.
             * @param toId ID of the destination node.
             * @param type Optional, association type, default:
             * Packages.de.elo.ix.client.WFNodeMatrixC.ALWAYS;
             */
            /*
            function removeAssoc(workflow, fromId, toId, type) {
            if (log.isDebugEnabled()) log.debug("removeAssoc(" + fromId + "->" + toId);
            
            // JavaScript array for associations
            var assocs = [];
            
            // Copy remaining associations to the JavaScript array
            for (var i = 0; i < workflow.getMatrix().getAssocs().length; i++) {
            var assoc = workflow.getMatrix().getAssocs()[i];
            if (assoc.nodeFrom != fromId || assoc.nodeTo != toId || (type && assoc.getType() != type)) {
            assocs.push(assoc);
            }
            }
            
            // Convert JavaScript array to Java array
            workflow.getMatrix().getAssocs() = assocs;
            
            // Discard internal helper objects
            workflow.getMatrix().dbHelper = null;
            
            if (log.isDebugEnabled()) log.debug(")removeAssoc"); 
            }
            */
            
            // Beispiel 176: Skriptfunktion zum Einfügen einer Knotenverbindung
            
            /**
             * Adds a new association to the node matrix.
             * @param workflow WFDiagram object
             * @param fromId ID of the source node.
             * @param toId ID of the destination node.
             * @param type Association type, see Packages.de.elo.ix.client.WFNodeMatrixC
             */
            /*
            function addAssoc(workflow, fromId, toId, type) {
            if (log.isDebugEnabled()) log.debug("addAssoc(" + fromId + "->" + toId);
            
            // Create new association object
            var ass = new Packages.de.elo.ix.client.WFNodeAssoc();
            ass.nodeFrom = fromId;
            ass.nodeTo = toId;
            if (type) {
            ass.getType() = type;
            } else {
            ass.getType() = Packages.de.elo.ix.client.WFNodeMatrixC.ALWAYS;
            }
            
            // Copy workflow assocs into a JavaScript array.
            var assocs = [];
            for (var i = 0; i < workflow.getMatrix().getAssocs().length; i++) {
            assocs.push(workflow.getMatrix().getAssocs()[i]);
            }
            
            // Add new association
            assocs.push(ass);
            
            // Convert JavaScript array to Java array
            workflow.getMatrix().getAssocs() = assocs;
            
            // Discard internal helper objects
            workflow.getMatrix().dbHelper = null;
            
            if (log.isDebugEnabled()) log.debug(")addAssoc");
            }
            */
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

    static void Wiedervorlage() {
        IXConnFactory connFact = new IXConnFactory("http://srvpdevbs01vm:8030/ix-common/ix", "Wiedervorlage", "1.0");
        // IXConnection conn = connFact.create("Administrator", "ELObs!dev", "localhost", null);
        // IXConnection conn = connFact.create("NormalerUser", "elo", "localhost", null);
        // IXConnection conn = connFact.create("Unittest", "elo", "localhost", null);
        IXConnection conn = (IXConnection) new Object();
        try {
            conn = connFact.create("Fritz", "", "localhost", null);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        
        // Beispiel 177: Wiedervorlagetermin erstellen
        String objId = "99328";
        String[] receiverIds = new String[] { "Ruberg", "Fritz" }; 

        Date dt = new Date(2017, 02, 01); 
        Reminder remi = new Reminder(); 
        try {
            remi = conn.ix().createReminder(objId);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        remi.setName("Reapplication"); 
        remi.setPromptDateIso(conn.dateToIso(dt)); 
        remi.setPrio(UserTaskPriorityC.HIGHEST); 
        remi.setDesc("..."); 

        int[] ids = new int[]{}; 
        try {
            ids = conn.ix().checkinReminder(remi, receiverIds, false, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        System.out.println("Created " + ids.length + " reminders");

        // Beispiel 178: Wiedervorlagetermine auflisten
        FindTasksInfo findInfo = new FindTasksInfo(); 
        findInfo.setInclReminders(true); 
        findInfo.setInclGroup(true); 
        findInfo.setInclDeputy(true); 
        findInfo.setLowestPriority(UserTaskPriorityC.LOWEST); 
        findInfo.setHighestPriority(UserTaskPriorityC.HIGHEST);

        int idx = 0; 
        FindResult fr = new FindResult();
        try {
            fr = conn.ix().findFirstTasks(findInfo, 1000);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        while (true) { 
            for (UserTask ut : fr.getTasks()) { 
                remi = ut.getReminder(); 
                if (remi != null) { 
                    System.out.println("Reminder:"); 
                    System.out.println(" id=" + remi.getId()); 
                    System.out.println(" name=" + remi.getName()); 
                    System.out.println(" from=" + remi.getSenderName()); 
                    System.out.println(" receiver=" + remi.getReceiverName()); 
                    System.out.println(" promptDate=" + conn.isoToDate(remi.getPromptDateIso())); 
                } 
            }
            idx += fr.getTasks().length; 
            if (!fr.isMoreResults()){ 
                break; 
            } 
            try {
                fr = conn.ix().findNextTasks(fr.getSearchId(), idx, 1000);
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        } 
        try {
            conn.ix().findClose(fr.getSearchId());
            
            // Beispiel 179: Wiedervorlagetermin bearbeiten
            /*
            int reminderId = remi.getId();
            remi = conn.ix().checkoutReminders(new int[] { reminderId }, LockC.YES)[0];
            
            remi.setReceiverId(conn.getUserId());
            remi.setReceiverName("");
            remi.setPrio(UserTaskPriorityC.LOWEST);
            remi.setDesc("Take over");
            conn.ix().checkinReminder(remi, null, false, LockC.YES);
            */
            // Beispiel 180: Wiedervorlagetermin löschen
            /*
            conn.ix().deleteReminders(new int[] { reminderId }, LockC.YES);
            */
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

    static void JavaScript() {
        IXConnFactory connFact = new IXConnFactory("http://srvpdevbs01vm:8030/ix-common/ix", "JavaScript", "1.0");
        // IXConnection conn = connFact.create("Administrator", "ELObs!dev", "localhost", null);
        // IXConnection conn = connFact.create("NormalerUser", "elo", "localhost", null);
        IXConnection conn = (IXConnection) new Object();
        try {
            conn = connFact.create("Unittest", "elo", "localhost", null);
            // IXConnection conn = connFact.create("Fritz", "", "localhost", null);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Beispiel 181: Workflow-Skripte installieren
        String[] fileNames = new String[] { "e:\\temp\\file1.js", "e:\\temp\\file2.js" };
        InsertScripts(conn, fileNames);
    }

    /// <summary> 
    /// This function inserts the given files into the archive 
    /// folder "Indexserver Scripting Base/_ALL/Tutorial". 
    /// </summary> 
    /// <param name="conn">IXConnection</param> 
    /// <param name="fileNames">File names</param>
    private  static void InsertScripts(IXConnection conn, String[] fileNames) {
        // Destination folder 
        String scriptFolder = "/_ALL/Tutorial"; 

        // Get destination script folder in the archive 
        int scriptFolderId = 0; 
        try {
            scriptFolderId = MakeArcPath(conn, conn.getCONST().getSORD().getGUID_IX_SCRIPTING_BASE(), scriptFolder);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Insert script files 
        for (String fileName : fileNames) { 
            File scriptFile = new File(fileName); 
            InsertScriptFile(conn, scriptFolderId, scriptFile); 
        } 

        try {
            // Indexserver must be reload in order to use the new
            // script(s) in a workflow.
            conn.ix().reload();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

    /// <summary> 
    /// Inserts a script file into the archive. 
    /// </summary> 
    /// <param name="conn">IXConnection</param> 
    /// <param name="scriptFolderId">Destination folder ID</param>
    /// <param name="scriptFile">Script file to be inserted</param>
    private static void InsertScriptFile(IXConnection conn, int scriptFolderId, File scriptFile) { 
        // Sord name is set to script file name without 
        // directory and extension 
        String sordName = scriptFile.getName();
        int p = sordName.lastIndexOf('.'); 
        if (p >= 0) sordName = sordName.substring(0, p); 

        EditInfo ed = new EditInfo(); 
        try { 
            // If the script exists, a new version is stored 
            ed = conn.ix().checkoutSord( "ARCPATH[" + scriptFolderId + "]:/" + sordName, EditInfoC.mbSordDocAtt, LockC.YES); 
        } 
        catch (RemoteException e) { 
            try {
                // The script does not exists: create a new document
                ed = conn.ix().createDoc("" + scriptFolderId, "", "", EditInfoC.mbSordDocAtt);
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
            ed.getSord().setName(sordName); 
        }

        ed.setDocument(new Document()); 
        ed.getDocument().setDocs(new DocVersion[] { new DocVersion() }); 
        ed.getDocument().getDocs()[0].setWorkVersion(true); 
        
        String fileName = scriptFile.getName();
        int lastIndexOfDot = fileName.lastIndexOf('.');
        String fileExtension;
        if (lastIndexOfDot > 0) {
            fileExtension = fileName.substring(lastIndexOfDot+1);
            ed.getDocument().getDocs()[0].setExt(fileExtension); 
        }        
        ed.getDocument().getDocs()[0].setFileData(new FileData()); 
        byte[] data = new byte[(int) scriptFile.length()];
        try (InputStream is = new FileInputStream(scriptFile)) {
            is.read(data);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        ed.getDocument().getDocs()[0].getFileData().setData(data);
        try {
            conn.ix().checkinDocEnd(ed.getSord(), SordC.mbAll, ed.getDocument(), LockC.YES);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

    static void FindWFVersion(IXConnection conn, String flowId) {
        WFVersion[] versions = new  WFVersion[]{}; 
        try {
            versions = conn.ix().getWorkflowTemplateVersions(flowId, false);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        for (WFVersion version : versions) { 
            System.out.println("id=" + version.getId() + ", version=" + version.getVersion() + 
                                                   ", is work-version=" + (version.getId() == 0) + 
                                                   ", comment=" + version.getVersion() + 
                                                   ", createDate=" + conn.isoToDate(version.getCreateDateIso()) + 
                                                   ", user=" + version.getUserName()); 
        }
    }

    static void FindWfLoop(IXConnection conn, FindWorkflowInfo findWfInfo) {
        int maxWf = 100;
        int idxWf = 0;
        FindResult fr = null;
        
        try {
            fr = conn.ix().findFirstWorkflows(findWfInfo, 100, WFDiagramC.mbLean);
            while (true) {
                for (WFDiagram wf1 : fr.getWorkflows()) {
                    System.out.println("id=" + wf1.getId() + ", name=" + wf1.getName() + ", overTimeLimit=" + wf1.isOverTimeLimit());
                }
                if (!fr.isMoreResults()) break;

                idxWf += fr.getWorkflows().length;
                fr = conn.ix().findNextWorkflows(fr.getSearchId(), idxWf, maxWf);
            }
        }
        catch (RemoteException ex) {
            ex.printStackTrace();
        }        
        finally {
            if (fr != null) {
                try {
                    conn.ix().findClose(fr.getSearchId());
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    // Beispiel 123: Suchschleife
    static void FindLoop(IXConnection conn, FindInfo fi) throws RemoteException {
        FindResult fr = null; 
        int max = 1000; 
        SordZ sordZ = new SordZ(SordC.mbId|SordC.mbName); 

        try { 
            int idx = 0; 
            fr = conn.ix().findFirstSords(fi, max, sordZ); 
            while (true) { 
                for (Sord sord : fr.getSords()) { 
                    System.out.println("name=" + sord.getName() + ", id=" + sord.getId()); 
                }
                if (!fr.isMoreResults()) break;

                idx += fr.getSords().length; 
                fr = conn.ix().findNextSords(fr.getSearchId(), idx, max, sordZ); 
            } 

            if (fr.isBreakTotalCount()) { 
                System.out.println("WARN: too many results"); 
            } 

            if (fr.isBreakTimeout()) {        
                System.out.println("WARN: timeout"); 
            } 
        } 
        finally { 
            if (fr != null) { 
                conn.ix().findClose(fr.getSearchId()); 
            } 
        }
    }

    // Beispiel 18: Originaldateiname setzen
    static void SetOriginalFileName(Sord sord, String fileName) { 
        ObjKey okeyFileName = null; 
        for (ObjKey okey : sord.getObjKeys()) { 
            if (okey.getId() == DocMaskLineC.ID_FILENAME) { 
                okeyFileName = okey; 
                break; 
            } 
        } 

        if (okeyFileName == null) { 
            okeyFileName = new ObjKey(); 
            okeyFileName.setId(DocMaskLineC.ID_FILENAME); 
            okeyFileName.setName(DocMaskLineC.NAME_FILENAME); 
            List<ObjKey> lst = new LinkedList<>(Arrays.asList(sord.getObjKeys())); 
            lst.add(okeyFileName); 
            sord.setObjKeys((ObjKey[])lst.toArray()); 
        } 

        File fileInfo = new File(fileName); 
        okeyFileName.setData(new String[] { fileInfo.getName() }); 
    }

    // Beispiel 22: Alle Dokumentversionen auflisten
    public static void DumpDocVersions(DocVersion[] dvs) { 
        if (dvs != null) { 
            for (DocVersion dv : dvs) {
                System.out.println(DocVersionToString(dv));
            }
        }
    }
    
    public static void ThreadSleep(int time) {
        try {        
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
            
    // Beispiel 67: Hintergrundprozess starten und überwachen
    public static String BackgroundJobLoop(IXConnection conn, NavigationInfo navInfo, ProcessInfo procInfo) { 
        JobState jobState = new JobState(); 
        try {
            jobState = conn.ix().processTrees(navInfo, procInfo);
            while (jobState != null && jobState.isJobRunning()) { 
                System.out.println("done=" + Long.toString(jobState.getCountProcessed()) + ", errors=" + Long.toString(jobState.getCountErrors())); 
                ThreadSleep(1000);  
                jobState = conn.ix().queryJobState(jobState.getJobGuid(), true, true, true); 
            } 
            
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        return (jobState != null) ? jobState.getJobGuid() : ""; 
    }

    public static String DocVersionToString(DocVersion dv) { 
        StringBuilder sbuf = new StringBuilder(); 
        sbuf.append("id=").append(dv.getId()); 
        sbuf.append(", version=").append(dv.getVersion()); 
        sbuf.append(", comment=").append(dv.getVersion()); 
        sbuf.append(", workVersion=").append(dv.isWorkVersion()); 
        sbuf.append(", deleted=").append(dv.isDeleted()); 
        return sbuf.toString(); 
    }

    public static int MakeArcPath(IXConnection conn, String parentId, String path) { 
        char delim = path.charAt(0);
        String[] sordNames; 
        sordNames = path.substring(1).split(Character.toString(delim));
        Sord[] sords = new Sord[sordNames.length]; 
        for (int i = 0; i < sords.length; i++) { 
            sords[i] = new Sord(); 
            sords[i].setName(sordNames[i]); 
        } 
        int[] ids = new int[]{}; 
        try {
            ids = conn.ix().checkinSordPath(parentId, sords, new SordZ(SordC.mbName));
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        return ids[ids.length - 1]; 
    }

    public static AclItem MakeAclItem(int type, int id, int access) { 
        AclItem ai = new AclItem(); 
        ai.setType(type); 
        ai.setId(id); 
        ai.setAccess(access); 
        return ai; 
    }

    public static boolean ArcPathExists(IXConnection conn, String arcPath) throws RemoteException { 
        String objId = "ARCPATH:" + arcPath; 
        return Exists(conn, objId); 
    }

    public static boolean Exists(IXConnection conn, String objId) throws RemoteException {
        boolean found = false; 
        try {
            found = true; 
        }
        catch (Exception e) { 
            if (conn.ix().parseException(e.getMessage()).getExceptionType() != IXExceptionC.NOT_FOUND) throw e; 
        } 
        return found;
    }

    private static void FindChildren(IXConnection conn, int parentId) { 
        FindInfo fi = new FindInfo(); 
        fi.setFindChildren(new FindChildren()); 
        fi.getFindChildren().setParentId(Integer.toString(parentId)); 

        SordZ sordZ = SordC.mbMin; 
        FindResult fr = null; 
        try { 
            int idx = 0; 
            fr = conn.ix().findFirstSords(fi, 1000, sordZ); 
            while (true) { 
                for (Sord sord : fr.getSords()) { 
                    System.out.println("sord.getName()=" + sord.getName() + ", isDocument=" + (sord.getType() >= SordC.LBT_DOCUMENT) + ", isReference=" + (sord.getParentId() != parentId)); 
                }
                if (!fr.isMoreResults()) break; 

                idx += fr.getSords().length; 
                fr = conn.ix().findNextSords(fr.getSearchId(), idx, 1000, sordZ);
            }
        }
        catch (RemoteException ex) { 
            ex.printStackTrace();
        }        finally { 
            if (fr != null) { 
                try { 
                    conn.ix().findClose(fr.getSearchId());
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                }
            } 
        }
    }

    private static String InsertSord(IXConnection conn, String parentId, String name) { 
        Sord sord = new Sord(); 
        try {
            sord = conn.ix().createSord(parentId, "", EditInfoC.mbSord).getSord();
            sord.setName(name);
            sord.setId(conn.ix().checkinSord(sord, SordC.mbAll, LockC.NO)); 
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        return Integer.toString(sord.getId()); 
    }

    private static void CleanupLoop(IXConnection conn, DeleteOptions delOpts) { 
        try {
            if (conn.ix().cleanupStart(delOpts)) {
                JobState jobState = conn.ix().cleanupState();
                while (jobState != null && jobState.isJobRunning()) {
                    System.out.println("done=" + Long.toString(jobState.getCountProcessed()) + ", errors=" + Long.toString(jobState.getCountErrors()));
                    ThreadSleep(1000);
                    jobState = conn.ix().cleanupState();
                } 
            }
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

    private static void DumpKeywordList(IXConnection conn, int indent, Keyword kw) { 
        // print keyword ID and text 
        StringBuilder sbuf = new StringBuilder(); 
        for (int i = 0; i < indent; i++) sbuf.append(" "); 

        sbuf.append("id=").append(kw.getId()); 
        sbuf.append(", text=").append(kw.getText());
        System.out.println(sbuf.toString()); 

        // read children, if not already read 
        if (kw.getChildren() == null) { 
            try { 
                kw = conn.ix().checkoutKeywords(new String[] { kw.getId() }, KeywordC.mbView, 1000, LockC.NO)[0];
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        } 

        // dump children 
        for (Keyword kwChild : kw.getChildren()) { 
            DumpKeywordList(conn, indent + 1, kwChild); 
        } 
    }

    // Beispiel 85: Verschlagwortungsgeschichte lesen
    public static void ExampleSordHist(IXConnection conn, String parentId) { 
        String maskId = "E-Mail"; 

        // Create a new Sord object 
        EditInfo ed; 
        Sord sord = new Sord();
        try {
            ed = conn.ix().createDoc(parentId, maskId, "", EditInfoC.mbSord);
            sord = ed.getSord(); 
            sord.setName("SordHist example"); 
            sord.getObjKeys()[0].setData(new String[] { "fritz@elo.com" });
            sord.getObjKeys()[1].setData(new String[] { "maria@elo.com" }); 
            sord.setId(conn.ix().checkinSord(sord, SordC.mbAll, LockC.NO)); 
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // History is empty for new Sord objects 
        DumpSordHistory(conn, sord.getGuid()); 

        // Sleep some seconds to get a different timestamp 
        System.out.println("sleep some seconds"); 
        ThreadSleep(5 * 1000); 

        // Modify the short description 
        System.out.println("modify name"); 
        sord.setName(sord.getName() + "- modified name"); 
        try { 
            sord.setId(conn.ix().checkinSord(sord, SordC.mbAll, LockC.NO));
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        // Sleep some seconds, because history is written in background 
        System.out.println("sleep some seconds"); 
        ThreadSleep(5 * 1000); 

        // History contains two entries 
        DumpSordHistory(conn, sord.getGuid()); 
    }

    private static void DumpSordHistory(IXConnection conn, String objId) { 
        SordHist[] sordHistory = new SordHist[]{}; 
        try {
            sordHistory = conn.ix().checkoutSordHistory(objId);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        System.out.println("SordHist.length=" + sordHistory.length); 

        for (SordHist sordHist : sordHistory) { 
            Date modifyDate = conn.isoToDate(sordHist.getTimeStampLocal()); 
            System.out.println(" SordHist: date=" + modifyDate + ", user=" + sordHist.getUserName()); 

            for (SordHistKey hkey : sordHist.getHistKeys()) { 
                System.out.println(" " + hkey.getKeyName() + "=" + hkey.getKeyData()); 
            } 
        } 
    }

    public static SortedMap<Integer, Color> MakeColorCache(IXConnection conn) { 
        ColorData[] colors = new ColorData[]{}; 
        try {
            colors = conn.ix().checkoutColors(LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        SortedMap<Integer, Color> colorMap = new TreeMap<>(); 
        for (ColorData color : colors) { 
            int red = color.getRGB() & 0xff; 
            int green = (color.getRGB() >> 8) & 0xff; 
            int blue = (color.getRGB() >> 16) & 0xff; 
            colorMap.put(color.getId(), Color.color(red, green, blue)); 
        } 
        return colorMap; 
    }

    private static void DumpAcl(AclItem[] aclItems) { 
        System.out.println("["); 
        for (AclItem aclItem : aclItems) { 
            System.out.println(AclItemToString(aclItem));
        } 
        System.out.println("]");
    }

    private static String AclItemToString(AclItem aclItem) { 
        StringBuilder sbuf = new StringBuilder(); 
        AclTypeToString(sbuf, aclItem); 
        IdNamesToString(sbuf, aclItem); 
        AccessToString(sbuf, aclItem); 
        return sbuf.toString(); 
    }

    private static void AclTypeToString(StringBuilder sbuf, AclItem aclItem) { 
        sbuf.append("["); 
        switch (aclItem.getType()) { 
            case AclItemC.TYPE_GROUP: 
                if (aclItem.getAndGroups() != null) { 
                    sbuf.append("AND-Group"); 
                } 
                else { 
                    sbuf.append("Group"); 
                } 
                break; 
            case AclItemC.TYPE_USER: 
                sbuf.append("User"); 
                break; 
            case AclItemC.TYPE_KEY: 
                sbuf.append("Key"); 
                break; 
            case AclItemC.TYPE_OWNER: 
                sbuf.append("Owner"); 
                break; 
            case AclItemC.TYPE_INHERIT: 
                sbuf.append("Inherit"); 
                break; 
        } 
        sbuf.append("]"); 
    }

    private static void IdNamesToString(StringBuilder sbuf, AclItem aclItem) { 
        if (aclItem.getType() == AclItemC.TYPE_GROUP ||
            aclItem.getType() == AclItemC.TYPE_USER || 
            aclItem.getType() == AclItemC.TYPE_KEY) { 
            sbuf.append("[").append(aclItem.getId()).append(",").append(aclItem.getName());

            if (aclItem.getAndGroups() != null) { 
                for (IdName idn : aclItem.getAndGroups()) { 
                    sbuf.append(",[").append(idn.getId()).append(",").append(idn.getName()).append("]"); 
                } 
            } 
            sbuf.append("]"); 
        }
    }

    private static void AccessToString(StringBuilder sbuf, AclItem aclItem) { 
        if (aclItem.getType() == AclItemC.TYPE_GROUP || 
            aclItem.getType() == AclItemC.TYPE_USER) { 
            sbuf.append("["); 
            if ((aclItem.getAccess() & AccessC.LUR_READ) != 0) 
                sbuf.append("READ,"); 
            if ((aclItem.getAccess() & AccessC.LUR_WRITE) != 0) 
                sbuf.append("WRITE,"); 
            if ((aclItem.getAccess() & AccessC.LUR_DELETE) != 0) 
                sbuf.append("DELETE,"); 
            if ((aclItem.getAccess() & AccessC.LUR_EDIT) != 0) 
                sbuf.append("EDIT,"); 
            if ((aclItem.getAccess() & AccessC.LUR_LIST) != 0) 
                sbuf.append("LIST,"); 
            if (sbuf.length() > 1) 
                sbuf.setLength(sbuf.length() - 1); 
            sbuf.append("]"); 
        } 
    }

    static void AnwenderOrdner() {

        IXConnFactory connFact = new IXConnFactory("http://srvpdevbs01vm:8030/ix-common/ix", "AnwenderOrdner", "1.0");
        IXConnection conn = (IXConnection) new Object();
        try {
            conn = connFact.create("Administrator", "ELObs!dev", "localhost", null);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        String userId = Integer.toString(conn.getUserId());
        System.out.println("userId=" + userId);

        UserInfo user = new UserInfo();
        try {
            user = conn.ix().checkoutUsers(new String[] { userId }, CheckoutUsersC.BY_IDS_RAW, LockC.YES)[0];
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        String userGuid = user.getGuid();
        System.out.println("user=" + user);
        System.out.println("user.getGuid()=" + user.getGuid());
        System.out.println("user.getName()=" + user.getName());

        // Anwenderordner über User-ID finden 
        Sord sord1 = new Sord();
        try {
            sord1 = conn.ix().checkoutSord("OKEY:ELOUSERID=" + userId, EditInfoC.mbSord, LockC.NO).getSord();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        System.out.println("sord1.getName()=" + sord1.getName());

        // Anwenderordner über User-GUID finden  
        Sord sord2 = new Sord();
        try {
            sord2 = conn.ix().checkoutSord("OKEY:ELOUSERGUID=" + userGuid, EditInfoC.mbSord, LockC.NO).getSord();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        System.out.println("sord2.getName()=" + sord2.getName());

        // Ordner Anwendername/data  
        Sord sord3 = new Sord();
        try {
            sord3 = conn.ix().checkoutSord("OKEY:ELOINDEX=" + conn.getCONST().getSORD().getELOINDEX_USER_FOLDER_DATA() + userGuid, SordC.mbMin, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        System.out.println("sord3.getName()=" + sord3.getName());

        // Ordner Anwendername/data/elo.profile  
        Sord sord4 = new Sord();
        try {
            sord4 = conn.ix().checkoutSord("OKEY:ELOINDEX=" + conn.getCONST().getSORD().getELOINDEX_USER_FOLDER_DATA_PROFILE() + userGuid, SordC.mbMin, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        System.out.println("sord4.getName()=" + sord4.getName());

        // Ordner Anwendername/Persönlicher Bereich  
        Sord sord5 = new Sord();
        try {
            sord5 = conn.ix().checkoutSord("OKEY:ELOINDEX=" + conn.getCONST().getSORD().getELOINDEX_USER_FOLDER_PRIVATE() + userGuid, SordC.mbMin, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        System.out.println("sord5.getName()=" + sord5.getName());

        // Ordner Anwendername/Postbox  
        Sord sord6 = new Sord();
        try {
            sord6 = conn.ix().checkoutSord("OKEY:ELOINDEX=" + conn.getCONST().getSORD().getELOINDEX_USER_FOLDER_INBOX() + userGuid, SordC.mbMin, LockC.NO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        System.out.println("sord6.getName()=" + sord6.getName());        
    }

    static void FeedService() {
        IXConnFactory connFact = new IXConnFactory("http://playground.dev.elo/ix-Solutions/ix", "IX-Tutorial", "1.0");
        IXConnection conn = (IXConnection) new Object();
        try {
            conn = connFact.create("Administrator", "elo", "localhost",null);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        System.out.println("ticket=" + conn.getLoginResult().getClientInfo().getTicket());
        System.out.println("IX-Url=" + conn.getEndpointUrl());


        String userId = Integer.toString(conn.getUserId());
        // UserInfo user = conn.ix().checkoutUsers(new String[] { userId }, CheckoutUsersC.BY_IDS_RAW, LockC.YES)[0];
        UserInfo user = new UserInfo();
        try {
            user = conn.ix().checkoutUsers(new String[] { "Schenk" }, CheckoutUsersC.BY_IDS_RAW, LockC.YES)[0];
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        Action action = new Action();
        try {
            action = conn.getFeedService().createAction(EActionType.UserComment, "2");
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        action.setText("Meine coole Action");
        action.setUserId(user.getId());
        action.setUserGuid(user.getGuid());
        action.setUserName(user.getName());
        try {
            String feedActionId = conn.getFeedService().checkinAction(action, ActionC.mbAll);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

    private static String DownloadDocumentToString(Sord s, IXConnection ixConn) {
        String docText = "";
        try {
            String objId = s.getId() + "";   
            String line;            
            BufferedReader in = null;
            String bom = "\uFEFF"; // ByteOrderMark (BOM);
            EditInfo editInfo = ixConn.ix().checkoutDoc(objId, null, EditInfoC.mbSordDoc, LockC.NO);
            if (editInfo.getDocument().getDocs().length > 0) {
                DocVersion dv = editInfo.getDocument().getDocs()[0];
                String url = dv.getUrl();                    
                InputStream inputStream = ixConn.download(url, 0, -1);
                try {
                    in = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));                    
                    while ((line = in.readLine()) != null) {
                        System.out.println("Gelesene Zeile: " + line);
                        docText = docText.concat(line);
                    }                       
                } catch (FileNotFoundException ex) {    
                    ex.printStackTrace();
                } catch (IOException ex) {            
                    ex.printStackTrace();
                } finally {
                    if (in != null) {
                        try {
                            in.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                docText = docText.replaceAll(bom, "");
                docText = docText.replaceAll("\b", "");
                docText = docText.replaceAll("\n", "");
            }            
        } catch (RemoteException ex) {
            ex.printStackTrace();            
        }
        return docText;
    }

    private static String getComputerName() {
        Map<String, String> env = System.getenv();
        if (env.containsKey("COMPUTERNAME"))
            return env.get("COMPUTERNAME");
        else if (env.containsKey("HOSTNAME"))
            return env.get("HOSTNAME");
        else
            return "Unknown Computer";
    }    
    
}
