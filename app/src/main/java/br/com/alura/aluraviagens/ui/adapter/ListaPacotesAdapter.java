package br.com.alura.aluraviagens.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.util.diasUtil;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.moedaUtil;
import br.com.alura.aluraviagens.util.resourceUtil;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int position) {
        return pacotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View viewInflated = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = pacotes.get(position);

        mostraLocal(viewInflated, pacote);
        mostraImagem(viewInflated, pacote);
        mostraDias(viewInflated, pacote);
        mostraPreco(viewInflated, pacote);

        return viewInflated;
    }

    private void mostraPreco(View viewInflated, Pacote pacote) {
        TextView preco = viewInflated.findViewById(R.id.item_pacote_preco);
        String moedaBrasileira = moedaUtil.formataMoedaBrasileira(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

    private void mostraDias(View viewInflated, Pacote pacote) {
        TextView dias = viewInflated.findViewById(R.id.item_pacote_dias);
        int quantidadeDias = pacote.getDias();
        String textoDias = diasUtil.formataDiasEmTexto(quantidadeDias);
        dias.setText(textoDias);
    }


    private void mostraImagem(View viewInflated, Pacote pacote) {
        ImageView imagem = viewInflated.findViewById(R.id.item_pacote_image);
        Drawable imageDrawable = resourceUtil.devolveDrawable(context, pacote.getImagem());
        imagem.setImageDrawable(imageDrawable);
    }


    private void mostraLocal(View viewInflated, Pacote pacote) {
        TextView local = viewInflated.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getLocal());
    }
}
