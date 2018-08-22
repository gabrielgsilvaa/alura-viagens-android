package br.com.alura.aluraviagens.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.dataUtil;
import br.com.alura.aluraviagens.util.diasUtil;
import br.com.alura.aluraviagens.util.moedaUtil;
import br.com.alura.aluraviagens.util.resourceUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo do Pacote";
    public static final String PACOTE = "pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle(TITULO_APPBAR);

        Intent intent = getIntent();

        if(intent.hasExtra(PACOTE)) {

            final Pacote pacote = (Pacote) intent.getSerializableExtra(PACOTE);

            mostraLocal(pacote);
            mostraImagem(pacote);
            mostraDias(pacote);
            mostraPreco(pacote);
            mostraData(pacote);

            Button botaoRealizaPAgamento = findViewById(R.id.resumo_pacote_botao_realiza_pagamento);
            botaoRealizaPAgamento.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
                    intent.putExtra(PACOTE, pacote);
                    startActivity(intent);

                }
            });

        }

    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_pacote_data);
        String dataFormatada = dataUtil.periodoEmTexto(pacote.getDias());
        data.setText(dataFormatada);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_pacote_preco);
        String precoFormatado = moedaUtil.formataMoedaBrasileira(pacote.getPreco());
        preco.setText(precoFormatado);
    }

    private void mostraDias(Pacote pacote) {
        TextView dias = findViewById(R.id.resumo_pacote_dias);
        String diasEmTexto = diasUtil.formataDiasEmTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawablePacote = resourceUtil.devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawablePacote);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacote.getLocal());
    }
}
