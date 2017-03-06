package br.senai.sp.informatica.todolist.util;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RestUtil {

    private static String readStream(InputStream inputStream) {
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String linha;

            while ((linha = reader.readLine()) != null) {
                builder.append(linha + "\n");
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e2) {
                    throw new RuntimeException("Erro2: " + e2.getMessage());
                }
            }
        }
        //
        return builder.toString();
    }

    public static void post(String json, String url, Context context) throws Exception {
        if (isConexaoDisponivel(context)) {
            //cria url
            URL endereco = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) endereco.openConnection();
            connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(15000);
            connection.connect();
            OutputStream output = connection.getOutputStream();
            output.write(json.getBytes("UTF-8"));
            output.flush();
            output.close();
            int satus = connection.getResponseCode();
            if (satus >= HttpURLConnection.HTTP_BAD_REQUEST) {
                throw new RuntimeException("Erro: " + satus);
            } else {
                // ler o token
            }


        } else {
            throw new RuntimeException("SEM CONEXÃO");
        }

    }

    public static boolean isConexaoDisponivel(Context context) {
        try {
            ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity == null) {
                return false;
            } else {
                NetworkInfo info = connectivity.getActiveNetworkInfo();
                if (info.getState().equals(NetworkInfo.State.CONNECTED)) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String get(String url, Context context) throws Exception {
        if (isConexaoDisponivel(context)) {
            //cria url
            URL endereco = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) endereco.openConnection();
            connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(15000);
            connection.connect();
            String json = null;

            int satus = connection.getResponseCode();
            if (satus == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                json = readStream(inputStream);
                inputStream.close();
                connection.disconnect();
                return json;
            } else {
                throw new RuntimeException("Erro: " + satus);
            }
        } else {
            throw new RuntimeException("SEM CONEXÃO");
        }
    }

    public static void delete( String url, Context context) throws Exception {
        if (isConexaoDisponivel(context)) {
            //cria url
            URL endereco = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) endereco.openConnection();
            connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            connection.setRequestMethod("DELETE");
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(15000);
            connection.connect();
            int satus = connection.getResponseCode();
            connection.disconnect();
            if (satus != HttpURLConnection.HTTP_NO_CONTENT) {
                throw new RuntimeException("Erro: " + satus);
            }

        } else {
            throw new RuntimeException("SEM CONEXÃO");
        }

    }

}
