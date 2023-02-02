package com.example.proyecto_libreria;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_libreria.clases.Comic;

public class ComicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public static final String EXTRA_COMIC_ITEM = "Esdras.comics.com";

    private TextView txt_item_id_comic;
    private TextView txt_item_tituloC;
    private TextView txt_item_autorC;
    private TextView txt_item_num_pagC;
    private  TextView txt_item_precioC;
    //-------------------------------------
    private ListaComicsAdapter lca;

    public ComicViewHolder(@NonNull View itemView)
    {
        super(itemView);
    }

    public ComicViewHolder(@NonNull View itemView, ListaComicsAdapter listaComicsAdapter)
    {
        super(itemView); // Esto debe ir primero para que hererde
        txt_item_id_comic = (TextView) itemView.findViewById(R.id.Id_txt_C);
        txt_item_tituloC = (TextView) itemView.findViewById(R.id.TituloDelComic_txt);
        txt_item_autorC = (TextView) itemView.findViewById(R.id.AutorC_txt);
        txt_item_num_pagC = (TextView) itemView.findViewById(R.id.Numero_paginasC_txt);
        txt_item_precioC = (TextView) itemView.findViewById(R.id.PrecioC_txt);
        // -----------------
        lca = listaComicsAdapter;
        itemView.setOnClickListener(this);
    }

    public TextView getTxt_item_id_comic() {
        return txt_item_id_comic;
    }

    public void setTxt_item_id_comic(TextView txt_item_id_comic) {
        this.txt_item_id_comic = txt_item_id_comic;
    }

    public TextView getTxt_item_tituloC() {
        return txt_item_tituloC;
    }

    public void setTxt_item_tituloC(TextView txt_item_tituloC) {
        this.txt_item_tituloC = txt_item_tituloC;
    }

    public TextView getTxt_item_autorC() {
        return txt_item_autorC;
    }

    public void setTxt_item_autorC(TextView txt_item_autorC) {
        this.txt_item_autorC = txt_item_autorC;
    }

    public TextView getTxt_item_num_pagC() {
        return txt_item_num_pagC;
    }

    public void setTxt_item_num_pagC(TextView txt_item_num_pagC) {
        this.txt_item_num_pagC = txt_item_num_pagC;
    }

    public TextView getTxt_item_precioC() {
        return txt_item_precioC;
    }

    public void setTxt_item_precioC(TextView txt_item_precioC) {
        this.txt_item_precioC = txt_item_precioC;
    }

    public ListaComicsAdapter getLca() {
        return lca;
    }

    public void setLca(ListaComicsAdapter lca) {
        this.lca = lca;
    }

    @Override
    public void onClick(View view)
    {
        int posicion = getLayoutPosition();
        Comic c = lca.getComics().get(posicion);
        Intent intent = new Intent(lca.getContexto(), activity_detalles_comic.class);
        intent.putExtra(EXTRA_COMIC_ITEM, c);
        lca.getContexto().startActivity(intent);
    }
}
