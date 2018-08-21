package br.com.alura.aluraviagens.ui.activity;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.BigDecimal;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.dataUtil;
import br.com.alura.aluraviagens.util.moedaUtil;
import br.com.alura.aluraviagens.util.resourceUtil;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo da Compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);

        setTitle(TITULO_APPBAR);

        Pacote pacote = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal(243.99));

        TextView local = findViewById(R.id.resumo_compra_local_pacote);
        local.setText(pacote.getLocal());

        ImageView imagem = findViewById(R.id.resumo_compra_imagem_pacote);
        Drawable drawablePacote = resourceUtil.devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawablePacote);

        TextView data = findViewById(R.id.resumo_compra_data_pacote);
        String periodoEmTexto = dataUtil.periodoEmTexto(pacote.getDias());
        data.setText(periodoEmTexto);

        TextView preco = findViewById(R.id.resumo_compra_preco_pacote);
        String moedaFormatada = moedaUtil.formataMoedaBrasileira(pacote.getPreco());
        preco.setText(moedaFormatada);
        
    }
}
