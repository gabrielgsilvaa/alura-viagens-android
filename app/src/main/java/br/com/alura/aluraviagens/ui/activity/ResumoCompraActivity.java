package br.com.alura.aluraviagens.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.dataUtil;
import br.com.alura.aluraviagens.util.moedaUtil;
import br.com.alura.aluraviagens.util.resourceUtil;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo da Compra";
    public static final String PACOTE = "pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);

        setTitle(TITULO_APPBAR);

        Intent intent = getIntent();

        if(intent.hasExtra(PACOTE)){

            Pacote pacote = (Pacote) intent.getSerializableExtra(PACOTE);

            mostraLocal(pacote);
            mostraImagem(pacote);
            mostraData(pacote);
            mostraPreco(pacote);
        }
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_compra_preco_pacote);
        String moedaFormatada = moedaUtil.formataMoedaBrasileira(pacote.getPreco());
        preco.setText(moedaFormatada);
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_compra_data_pacote);
        String periodoEmTexto = dataUtil.periodoEmTexto(pacote.getDias());
        data.setText(periodoEmTexto);
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_compra_imagem_pacote);
        Drawable drawablePacote = resourceUtil.devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawablePacote);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_compra_local_pacote);
        local.setText(pacote.getLocal());
    }
}
