package br.senai.sp.informatica.todolist.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import br.senai.sp.informatica.todolist.fragment.TarefaFragment;

/**
 * Created by Tecnico_Manha on 06/03/2017.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        Bundle args = new Bundle();
        switch (position) {
            case 0:
                args.putInt("tipoLista", 0);
                TarefaFragment fragmentZero = new TarefaFragment();
                fragmentZero.setArguments(args);
                return fragmentZero;

            case 1:
                args.putInt("tipoLista", 1);
                TarefaFragment fragmentUm = new TarefaFragment();
                fragmentUm.setArguments(args);
                return fragmentUm;
        }
        return new Fragment();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Em Aberto";
            case 1:
                return "Todas";
            default:
                return "";
        }

    }
}
