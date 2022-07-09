package com.notificationservices.service.imp;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.notificationservices.service.LoginServices;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import static com.notificationservices.config.Utils.*;

/**
 * @author Ehtiram_Abdullayev on 17.12.2018
 * @project notificationservices
 */
public class LoginServicesImp implements LoginServices {

    private static Credential credentialInstance;
    private static final String  TOKENS_DIRECTORY_PATH = "tokens";
    private static final String[] scopeNames = {"https://www.googleapis.com/auth/calendar",
                                          "https://www.googleapis.com/auth/calendar.readonly"
    };
    private static final List<String> SCOPES = Arrays.asList(scopeNames);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

     public static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
         if (credentialInstance == null){
             InputStream in = LoginServicesImp.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
             GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

             // Build flow and trigger user authorization request.
             GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                     HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                     .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                     .setAccessType("offline")
                     .build();
             LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
             credentialInstance = new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
         }
        return credentialInstance;
    }

}
