package za.ac.cput.assignment6;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class viewContractActivity extends Activity {

//    private ContractServiceImpl service;
//    private boolean isBound;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contract);
    }

//    @Override
//    protected void onStart()
//    {
//        super.onStart();
//
//        Intent intent = new Intent(this, ContractServiceImpl.class);
//        GlobalContext.context = this;
//        service = ContractServiceImpl.getInstance();
//        GlobalContext.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);
//
//        try{
//            ArrayList<Contract> myList = service.getContracts();
//            ArrayList<String> displayValues = new ArrayList<String>();
//
//            for(Contract area: myList)
//                displayValues.add(area.getIdCheckNum() + " - " + area.getDetailsCheckNum());
//
//            ArrayAdapter<String> arrayAdapter =
//                    new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, displayValues);
//
//            ListView listView = (ListView)findViewById(R.id.listViewContracts);
//
//            listView.setAdapter(arrayAdapter);
//        }
//        catch(Exception x)
//        {
//            x.printStackTrace();
//        }
//    }
//
//    private ServiceConnection connection = new ServiceConnection() {
//        @Override
//        public void onServiceConnected(ComponentName name, IBinder localService) {
//            ContractServiceImpl.ActivateServiceLocalBinder binder
//                    = (ContractServiceImpl.ActivateServiceLocalBinder) localService;
//            service = binder.getService();
//            isBound = true;
//        }
//        @Override
//        public void onServiceDisconnected(ComponentName name) {
//            isBound = false;
//        }
//    };

    public void returnHome(View view)
    {
        Intent intent = new Intent (this, homeActivity.class);
        startActivity(intent);
    }
}
