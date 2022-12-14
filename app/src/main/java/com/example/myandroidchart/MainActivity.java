package com.example.myandroidchart;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.LineData;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    BarChart barChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        barChart = findViewById(R.id.chart);
        BarData data = new BarData(getLabel(), getDataSet());
        barChart.setData(data);

        barChart.setDescription("Barchart");
        barChart.animateXY(100, 100);
        barChart.invalidate();





    }
    private ArrayList getLabel() {
        ArrayList xLabel = new ArrayList();

        xLabel.add("Jan");
        xLabel.add("Feb");
        xLabel.add("Mar");
        xLabel.add("Apr");
        xLabel.add("May");
        xLabel.add("Jun");

        return xLabel;


    }

    private ArrayList getDataSet() {

        ArrayList dataSets = null;

        ArrayList valueSet1 = new ArrayList();
        ArrayList valueSet2 = new ArrayList();


        //BarEntry vs11 = new BarEntry(115.00f, 0);
        //BarEntry vs12 = new BarEntry(115.00f, 0);
        //BarEntry vs13 = new BarEntry(115.00f, 0);
        //BarEntry vs14 = new BarEntry(115.00f, 0);
        //BarEntry vs15 = new BarEntry(115.00f, 0);
        //BarEntry vs16 = new BarEntry(115.00f, 0);
        //BarEntry vs21 = new BarEntry(115.00f, 0);
        //BarEntry vs22 = new BarEntry(115.00f, 0);
        //BarEntry vs23 = new BarEntry(115.00f, 0);
        //BarEntry vs24 = new BarEntry(115.00f, 0);
        //BarEntry vs25 = new BarEntry(115.00f, 0);
        //BarEntry vs26 = new BarEntry(115.00f, 0);

        float val;
        for (int i = 0; i < 6; i++){
            val = (float) (Math.random() * 200) - 30 ;
            valueSet1.add(new BarEntry(val, i));

            val = (float) (Math.random() * 200) - 30 ;
            valueSet2.add(new BarEntry(val, i));
        }
//        valueSet1.add(vs11);
//        valueSet1.add(vs12);
//        valueSet1.add(vs13);
//        valueSet1.add(vs14);
//        valueSet1.add(vs15);
//        valueSet1.add(vs16);
//        valueSet2.add(vs21);
//        valueSet2.add(vs22);
//        valueSet2.add(vs23);
//        valueSet2.add(vs24);
//        valueSet2.add(vs25);
//        valueSet2.add(vs26);
        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Data Set 1");
        BarDataSet barDataSet2 = new BarDataSet(valueSet2, "Data Set 2");
        barDataSet1.setColor(Color.rgb(0, 200, 0));
        barDataSet2.setColor(Color.rgb(0, 0, 200));

        dataSets = new ArrayList();
        dataSets.add(barDataSet1);
        dataSets.add(barDataSet2);

        return dataSets;
    }



}