package br.com.alura.aluraviagens.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.moedaUtil;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";
    public static final String PACOTE = "pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        setTitle(TITULO_APPBAR);

        Intent intent = getIntent();

        if(intent.hasExtra(PACOTE)){
            final Pacote pacote = (Pacote) intent.getSerializableExtra(PACOTE);

            mostraPreco(pacote);

            Button botaoFinalizaCompra = findViewById(R.id.pagamento_botao_finaliza_compra);
            botaoFinalizaCompra.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
                    intent.putExtra(PACOTE, pacote);
                    startActivity(intent);
                }
            });


        }

    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco_pacote);
        String moedaBrasileira = moedaUtil.formataMoedaBrasileira(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }
}
