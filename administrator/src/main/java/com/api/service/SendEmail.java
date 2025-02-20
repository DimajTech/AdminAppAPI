package com.api.service;

import com.api.model.Email;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class SendEmail {
    private static final String API_EMAIL_URL = "http://localhost:5092/api/SendEmail/SendEmail";
    private static final HttpClient httpClient;

    // Bloque estático para inicializar el HttpClient
    static {
        httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();
    }

    public SendEmail() {}

    public static void sendRegistrationEmail(String userEmail, String status) throws Exception {
        Email email = new Email();
        email.setToUser(userEmail);
        email.setSubject("Solicitud de registro " + status);
        String content = """
                <html lang='es'>
                    <head>
                        <meta charset='UTF-8'>
                        <meta name='viewport' content='width=device-width, initial-scale=1.0'>
                        <title>Email de Bienvenida</title>
                        <style>
                            body {
                                font-family: Arial, sans-serif;
                                background-color: #f4f4f4;
                                padding: 20px;
                            }
                            .container {
                                max-width: 600px;
                                background: #ffffff;
                                padding: 20px;
                                border-radius: 8px;
                                box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
                                text-align: center;
                            }
                            .logo {
                                width: 300px;
                                margin-bottom: 20px;
                            }
                            h1 { color: #00693e; }
                            p { color: #333; font-size: 16px; }
                            .footer {
                                margin-top: 20px;
                                font-size: 12px;
                                color: #666;
                            }
                        </style>
                    </head>
                    <body>
                        <div class='container'>
                            <img src='https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEh5057rSlx1GVQGuaLOV0oMvYZnSlUUm5szF7HaA_sSFdbVuAQ-oSBKMjBHjjX2YSZtBaIhY6ccW7jGKp3j_mi-eYL58Sz2oS3ZRDMY0V1bzOEaRUsnUsMqEGvaT7-zcwqIxGdkmEi-0DsO/w1200-h630-p-k-no-nu/UCR+logo+transparente.png' alt='Logo UCR' class='logo'>
                            <h1>Resultado de su solicitud de registro</h1>
                            <p>Su solicitud de registro en la aplicación fue %s</p>
                            <p class='footer'>Si tiene alguna duda, no dude en ponerse en contacto con nosotros.</p>
                        </div>
                    </body>
                </html>
                """.formatted(status);

        email.setContent(content);

        JSONObject emailJson = new JSONObject();
        emailJson.put("ToUser", email.getToUser());
        emailJson.put("Subject", email.getSubject());
        emailJson.put("Content", email.getContent());

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(API_EMAIL_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(emailJson.toString(), StandardCharsets.UTF_8))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
