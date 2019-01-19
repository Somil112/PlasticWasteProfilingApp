package org.tensorflow.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class showGraph extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showgraph);
        Intent getdata = getIntent();
        int coca_cola_count = getdata.getIntExtra("cocacola_count",0);
        ArrayList noofproducts = new ArrayList();
        PieChart piechart = (PieChart)findViewById(R.id.piechart);
        noofproducts.add(new PieEntry(100f, "Coca Cola" ));
        noofproducts.add(new PieEntry(50f,"Lays"));
        noofproducts.add(new PieEntry(40f,"Maggi"));
        PieDataSet dataset = new PieDataSet(noofproducts,"Products Found");

        PieData data=new PieData(dataset) ;
        piechart.setData(data);
        piechart.setDescription("PWP");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        piechart.animateXY(5000,5000);


    }
}
