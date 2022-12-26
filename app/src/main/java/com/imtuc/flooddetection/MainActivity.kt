package com.imtuc.flooddetection

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.imtuc.flooddetection.adapter.Adapter
import com.imtuc.flooddetection.adapter.SuhuAdapter
import com.imtuc.flooddetection.databinding.ActivityMainBinding
import com.imtuc.flooddetection.model.HuluHilir
import com.imtuc.flooddetection.model.Suhu

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var huluArrayList: ArrayList<HuluHilir> = arrayListOf()
    private var hilirArrayList: ArrayList<HuluHilir> = arrayListOf()
    private var suhuArrayList: ArrayList<Suhu> = arrayListOf()
    private lateinit var adapterHulu: Adapter
    private lateinit var adapterHilir: Adapter
    private lateinit var adapterSuhu: SuhuAdapter
    private lateinit var manager1: LinearLayoutManager
    private lateinit var manager2: LinearLayoutManager
    private lateinit var manager3: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAdapter()
        getDataHulu()
        getDataHilir()
        getDataSuhu()
    }

    private fun getDataHulu() {
        val database = Firebase.database
        val ref = database.getReference("hulu")

        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    var tmpArrList = arrayListOf<HuluHilir>()

                    for (classSnapshot in snapshot.children) {
                        var distance = classSnapshot.child("distance").getValue().toString()
                        var datetime = classSnapshot.child("timestamp").getValue().toString()

                        var hulu = HuluHilir(distance, datetime)

                        tmpArrList.add(hulu!!)
                    }

                    huluArrayList.clear()
                    huluArrayList.addAll(tmpArrList)
                    tmpArrList.clear()

                    adapterHulu.notifyDataSetChanged()

                    binding.huluRv.smoothScrollToPosition(binding.huluRv.adapter!!.itemCount - 1)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("Data", error.getMessage()) //Don't ignore errors!
            }

        })
    }

    private fun getDataHilir() {
        val database = Firebase.database
        val ref = database.getReference("hilir")

        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    var tmpArrList = arrayListOf<HuluHilir>()

                    for (classSnapshot in snapshot.children) {
                        var distance = classSnapshot.child("distance").getValue().toString()
                        var datetime = classSnapshot.child("timestamp").getValue().toString()

                        var hilir = HuluHilir(distance, datetime)

                        tmpArrList.add(hilir!!)
                    }

                    hilirArrayList.clear()
                    hilirArrayList.addAll(tmpArrList)
                    tmpArrList.clear()

                    adapterHilir.notifyDataSetChanged()

                    binding.hilirRv.smoothScrollToPosition(binding.hilirRv.adapter!!.itemCount - 1)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("Data", error.getMessage()) //Don't ignore errors!
            }

        })
    }

    private fun getDataSuhu() {
        val database = Firebase.database
        val ref = database.getReference("temp")

        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    var tmpArrList = arrayListOf<Suhu>()

                    for (classSnapshot in snapshot.children) {
                        var celcius = classSnapshot.child("celcius").getValue().toString()
                        var fahrenheit = classSnapshot.child("fahrenheit").getValue().toString()
                        var datetime = classSnapshot.child("timestamp").getValue().toString()

                        var suhu = Suhu(celcius, fahrenheit, datetime)

                        tmpArrList.add(suhu!!)
                    }

                    suhuArrayList.clear()
                    suhuArrayList.addAll(tmpArrList)
                    tmpArrList.clear()

                    adapterHilir.notifyDataSetChanged()

                    binding.suhuRv.smoothScrollToPosition(binding.hilirRv.adapter!!.itemCount - 1)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("Data", error.getMessage()) //Don't ignore errors!
            }

        })
    }

    private fun setAdapter() {
        //Hulu
        adapterHulu = Adapter(huluArrayList)

        manager1 = LinearLayoutManager(this)
        manager1.reverseLayout = true
        manager1.stackFromEnd = true

        binding.huluRv.layoutManager = manager1
        binding.huluRv.adapter = adapterHulu

        //Hilir
        adapterHilir = Adapter(hilirArrayList)

        manager2 = LinearLayoutManager(this)
        manager2.reverseLayout = true
        manager2.stackFromEnd = true

        binding.hilirRv.layoutManager = manager2
        binding.hilirRv.adapter = adapterHilir

        //Suhu
        adapterSuhu = SuhuAdapter(suhuArrayList)

        manager3 = LinearLayoutManager(this)
        manager3.reverseLayout = true
        manager3.stackFromEnd = true

        binding.suhuRv.layoutManager = manager3
        binding.suhuRv.adapter = adapterSuhu
        
        Log.d("Adapter", "Set Adapter Successful")

    }
}