package com.example.recyclerview;

import android.support.annotation.NonNull;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    FirebaseDatabase database;
    DatabaseReference root;
    FloatingActionButton add;
    EditText topic,decs;


    RecyclerView rc;


    List<com.example.recyclerview.Todo> list;


//    String[] names={"CaptainAmerica","IronMan","SpiderMan","Thor",
//            "AntMan","CaptainMarvel","BlackPather",
//            "Dr. Hulk","StarLoard","Gumoora","Groot"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        add=findViewById(R.id.add);
        topic=findViewById(R.id.topic);
        decs=findViewById(R.id.desc);


        //init the recycler view object
        rc=findViewById(R.id.rc);
        rc.setLayoutManager(new LinearLayoutManager(MainActivity.this));



        list=new ArrayList<>();




        database=FirebaseDatabase.getInstance();


        root=database.getReference("todo");

//        rc=findViewById(R.id.rc);
//        rc.setLayoutManager(new LinearLayoutManager(
//                MainActivity.this));


        //root.setValue();





        //receciving the data from server
        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot d:dataSnapshot.getChildren()){

                    com.example.recyclerview.Todo t=d.getValue(com.example.recyclerview.Todo.class);

                    list.add(t);
                }

                rc.setAdapter(new Adapter(MainActivity.this,list));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }
        });



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String key=root.push().getKey();

                root.child(key).setValue(new com.example.recyclerview.Todo(topic.getText().toString(),
                        decs.getText().toString(),"not done"))
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){

                                    Toast.makeText(MainActivity.this,
                                            "added", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });







    }
}