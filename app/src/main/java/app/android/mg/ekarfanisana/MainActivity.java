package app.android.mg.ekarfanisana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.StringJoiner;

import app.android.mg.ekarfanisana.model.Messe;

public class MainActivity extends AppCompatActivity {
    //declaration des vues
    Button btnAddLehibe, btnAddTanora, btnAddAnkizy, btnAddZaza, btnValider, btnReinitialliser;
    TextView txtLehibe, txtTanora, txtAnkizy, txtZaza, txtTotal;
    int nbLehibe = 0;
    int nbTanora = 0;
    int nbAnkizy = 0;
    int nbZaza = 0;
    int nbTotal = 0;
    protected Messe messe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //récuperation des vues
        btnAddLehibe = findViewById(R.id.btn_add_lehibe);
        btnAddTanora = findViewById(R.id.btn_add_tanora);
        btnAddAnkizy = findViewById(R.id.btn_add_ankizy);
        btnAddZaza = findViewById(R.id.btn_add_zaza);
        btnValider = findViewById(R.id.btn_valider);
        btnReinitialliser = findViewById(R.id.btn_reinitialiser);
        txtLehibe = findViewById(R.id.txt_nb_lehibe);
        txtTanora = findViewById(R.id.txt_nb_tanora);
        txtAnkizy = findViewById(R.id.txt_nb_ankizy);
        txtZaza = findViewById(R.id.txt_nb_zaza);
        txtTotal=findViewById(R.id.txt_nb_total);

        btnReinitialliser.setAlpha(0f);

        //event bouton
        btnAddLehibe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nbLehibe++;
                txtLehibe.setText(String.valueOf(nbLehibe));
            }
        });
        btnAddTanora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nbTanora++;
                txtTanora.setText(String.valueOf(nbTanora));
            }
        });
        btnAddAnkizy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nbAnkizy++;
                txtAnkizy.setText(String.valueOf(nbAnkizy));
            }
        });
        btnAddZaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nbZaza++;
                txtZaza.setText(String.valueOf(nbZaza));
            }
        });
        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //initialisation variable messe
                messe = new Messe(nbLehibe,nbTanora,nbAnkizy,nbZaza);
                //récupvaleurs des txtviews.

                txtTotal.setText("Isan'ireo tonga nivavaka : \n" + String.valueOf(messe.getNombreTotal()));
                //désactivation des boutons
                btnAddLehibe.setEnabled(false);
                btnAddTanora.setEnabled(false);
                btnAddAnkizy.setEnabled(false);
                btnAddZaza.setEnabled(false);
                btnValider.setEnabled(false);
                btnReinitialliser.setAlpha(1f);
                btnReinitialliser.setEnabled(true);
            }
        });
        btnReinitialliser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtTotal.setText(null);
                txtLehibe.setText(null);
                txtTanora.setText(null);
                txtAnkizy.setText(null);
                txtZaza.setText(null);
                //enable buttons
                btnAddTanora.setEnabled(true);
                btnAddAnkizy.setEnabled(true);
                btnAddZaza.setEnabled(true);
                btnAddLehibe.setEnabled(true);
                btnValider.setEnabled(true);
                //reinitiallisation des variables
                nbLehibe = nbTanora = nbAnkizy = nbZaza = nbTotal = 0;
                //disparition bouton
                btnReinitialliser.setAlpha(0f);
                btnReinitialliser.setEnabled(false);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_sauvegarder:
                Toast.makeText(this, R.string.sauvegarder, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_quitter:
                Toast.makeText(this, R.string.quitter, Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
