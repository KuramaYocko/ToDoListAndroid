package br.senai.sp.informatica.todolist.rest;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import br.senai.sp.informatica.todolist.modelo.Tarefa;
import br.senai.sp.informatica.todolist.util.PrefsUtil;
import br.senai.sp.informatica.todolist.util.RestUtil;


public class TarefaRest {

    public static void novaTarefa(Tarefa tarefa, Context context) throws Exception {
        String url = PrefsUtil.getEndereco(context)+"/tarefa";
        Gson gson= new Gson();
        RestUtil.post(gson.toJson(tarefa),url,context);
    }

    public static List<Tarefa> listarTodas(Context context) throws Exception{
        String url = PrefsUtil.getEndereco(context)+"/tarefa";
        Gson gson = new Gson();
        String json = RestUtil.get(url,context);
        Type typeList = new TypeToken<List<Tarefa>>(){}.getType();
        return gson.fromJson(json,typeList);
    }
    public static List<Tarefa> listarAbertas(Context context) throws Exception{
        String url = PrefsUtil.getEndereco(context)+"/tarefa/abertas";
        Gson gson = new Gson();
        String json = RestUtil.get(url,context);
        Type typeList = new TypeToken<List<Tarefa>>(){}.getType();
        return gson.fromJson(json,typeList);
    }

    public static void deletarTarefa(Tarefa tarefa, Context context) throws Exception {
        String url = PrefsUtil.getEndereco(context)+"/tarefa/"+ tarefa.getId();
        RestUtil.delete(url,context);
    }
}
