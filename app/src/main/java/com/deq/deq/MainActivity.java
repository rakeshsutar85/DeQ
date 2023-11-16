package com.deq.deq;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText name, time, orderData;
    private Button orderButton;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    private String OrderID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.idEdtName);
        time = findViewById(R.id.idEdtTime);
        orderData = findViewById(R.id.idEdtOrd);
        orderButton = findViewById(R.id.idBtnOrder);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Orders");

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String PersonName = name.getText().toString();
                String ArrivalTime = time.getText().toString();
                String OrderData = orderData.getText().toString();
                OrderID = PersonName;
                OrderModel orderModel = new OrderModel(PersonName, ArrivalTime, OrderData, OrderID);
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        databaseReference.child(orderModel.getOrderID()).setValue(orderModel);
                        Toast.makeText(MainActivity.this, "Order Placed", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, MainActivity.class));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(MainActivity.this, "Error is" + error.toString(), Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }
}