package org.tensorflow.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.tensorflow.demo.env.Logger;
import java.util.ArrayList;


public class storeData extends Activity {
    private final Logger logger = new Logger();
    TextView coca_cola;
    Integer coca_cola_count=0;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showdata);

        submit=(Button)findViewById(R.id.submitdata);
        Intent getdata = getIntent();
        Bundle args = getdata.getBundleExtra("BUNDLE");
        ArrayList<String> objname = (ArrayList<String>) args.getSerializable("Objectname");
        ArrayList<String> objlocation = (ArrayList<String>) args.getSerializable("Objectlocation");
        ArrayList<String> conflevel = (ArrayList<String>) args.getSerializable("Confidencelevel");

        Integer i;
        for(i=0;i<=objname.size()-1;i++)
        {
            if(objname.get(i).equals("coca_cola"))
            {
                logger.i("Inside loop");
                coca_cola_count=coca_cola_count+1;
                logger.i("Coca cola count is " + coca_cola_count);
            }
        }

        logger.i(objname.get(0) + " found with confidence level "+ conflevel.get(0)+" at location "+objlocation.get(0));

        coca_cola=(TextView)findViewById(R.id.cocacola);
        coca_cola.append(" "+ String.valueOf(coca_cola_count));
        submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent showgraph = new Intent(storeData.this,showGraph.class);
                        showgraph.putExtra("cocacola_count",coca_cola_count);
                        startActivity(showgraph);
                    }
                }
        );






    }
}
