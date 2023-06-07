package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import com.example.webview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

   private ActivityMainBinding mbinding;

   private EditText editText1;
   private Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        mbinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mbinding.getRoot());

        editText1 = mbinding.editText1;
        button1 = mbinding.button1;
        


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                mostrarFragmento();

            }
        });

    }

    private void mostrarFragmento() {
        String direccion="";
        if ((""+editText1.getText()).equals("")) {
            direccion="https://www.google.com/?hl=es";
        }
            else{
            direccion=""+editText1.getText();
            }


        // Crea una instancia del fragmento BlankFragment
        BlankFragment fragment = BlankFragment.newInstance(direccion);
        // Obtiene el administrador de fragmentos
        FragmentManager fragmentManager = getSupportFragmentManager();
        // Inicia una transacción de fragmento
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // Reemplaza el contenido del contenedor con el fragmento BlankFragment
        transaction.replace(mbinding.container.getId(), fragment);
        // Opcional: añade la transacción a la pila de retroceso
        transaction.addToBackStack(null);
        // Realiza la transacción
        transaction.commit();

    }


}