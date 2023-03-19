package xyz.android.recyclerviewadaptadores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText textInputEditText;
    private List<String> myDataset;
    private RecyclerView mrecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtener referencias a los elementos de la vista
        textInputEditText = findViewById(R.id.editTxtNombre);
        mrecyclerView = findViewById(R.id.recycler_view);

        // Configurar el RecyclerView
        mrecyclerView.setHasFixedSize(true);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Inicializar los datos del conjunto de datos
        myDataset = new ArrayList<>();

        // Cargar el adapter inicial
        loadConfigAdapter();
    }

    public void addNewName(View view) {
        // Obtener el nombre ingresado en el TextInputEditText
        String nombre = textInputEditText.getText().toString();

        // Verificar si el nombre está vacío
        if (nombre.isEmpty()) {
            showAlert("Por favor, ingrese un nombre");
            return;
        }

        // Agregar el nombre al conjunto de datos
        myDataset.add(nombre);

        // Limpiar el TextInputEditText
        textInputEditText.setText("");

        // Actualizar el RecyclerView con el nuevo conjunto de datos
        loadConfigAdapter();
    }

    private void loadConfigAdapter() {
        // Crear y configurar el adapter
        MyAdapter myAdapter = new MyAdapter(myDataset);
        mrecyclerView.setAdapter(myAdapter);
    }

    private void showAlert(String message) {
        new MaterialAlertDialogBuilder(this)
                .setTitle("Error")
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show();
    }

}
