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
    private var hulu2ArrayList: ArrayList<HuluHilir> = arrayListOf()
    private var hilirArrayList: ArrayList<HuluHilir> = arrayListOf()
    private var hilir2ArrayList: ArrayList<HuluHilir> = arrayListOf()
    private var suhuArrayList: ArrayList<Suhu> = arrayListOf()
    private var suhu2ArrayList: ArrayList<Suhu> = arrayListOf()
    private lateinit var adapterHulu: Adapter
    private lateinit var adapterHulu2: Adapter
    private lateinit var adapterHilir: Adapter
    private lateinit var adapterHilir2: Adapter
    private lateinit var adapterSuhu: SuhuAdapter
    private lateinit var adapterSuhu2: SuhuAdapter
    private lateinit var manager1: LinearLayoutManager
    private lateinit var manager2: LinearLayoutManager
    private lateinit var manager3: LinearLayoutManager
    private lateinit var manager12: LinearLayoutManager
    private lateinit var manager22: LinearLayoutManager
    private lateinit var manager32: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAdapter()
        getDataHulu2()
        getDataHulu()
        getDataHilir2()
        getDataHilir()
        getDataSuhu2()
        getDataSuhu()
    }

    private fun getDataHulu() {
        val database = Firebase.database
        val ref = database.getReference("sungai1")

        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    var tmpArrList = arrayListOf<HuluHilir>()

                    for (classSnapshot in snapshot.child("hulu").children) {
                        var distance = classSnapshot.child("hasil").getValue().toString()
                        var datetime = classSnapshot.child("timestamp").getValue().toString()

                        var hulu = HuluHilir(distance, datetime)

                        tmpArrList.add(hulu!!)
                    }

                    huluArrayList.clear()
                    huluArrayList.addAll(tmpArrList)
                    tmpArrList.clear()

                    adapterHulu.notifyDataSetChanged()

                    if (binding.huluRv.adapter!!.itemCount > 0) {
                        binding.huluRv.smoothScrollToPosition(binding.huluRv.adapter!!.itemCount - 1)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("Data", error.getMessage()) //Don't ignore errors!
            }

        })
    }

    private fun getDataHulu2() {
        val database = Firebase.database
        val ref = database.getReference("sungai2")

        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    var tmpArrList = arrayListOf<HuluHilir>()

                    for (classSnapshot in snapshot.child("hulu").children) {
                        var distance = classSnapshot.child("hasil").getValue().toString()
                        var datetime = classSnapshot.child("timestamp").getValue().toString()

                        var hulu = HuluHilir(distance, datetime)

                        tmpArrList.add(hulu!!)
                    }

                    hulu2ArrayList.clear()
                    hulu2ArrayList.addAll(tmpArrList)
                    tmpArrList.clear()

                    adapterHulu2.notifyDataSetChanged()

                    if (binding.hulu2Rv.adapter!!.itemCount > 0) {
                        binding.hulu2Rv.smoothScrollToPosition(binding.hulu2Rv.adapter!!.itemCount - 1)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("Data", error.getMessage()) //Don't ignore errors!
            }

        })
    }

    private fun getDataHilir() {
        val database = Firebase.database
        val ref = database.getReference("sungai1")

        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    var tmpArrList = arrayListOf<HuluHilir>()

                    for (classSnapshot in snapshot.child("hilir").children) {
                        var distance = classSnapshot.child("hasil").getValue().toString()
                        var datetime = classSnapshot.child("timestamp").getValue().toString()

                        var hilir = HuluHilir(distance, datetime)

                        tmpArrList.add(hilir!!)
                    }

                    hilirArrayList.clear()
                    hilirArrayList.addAll(tmpArrList)
                    tmpArrList.clear()

                    adapterHilir.notifyDataSetChanged()

                    if (binding.hilirRv.adapter!!.itemCount > 0) {
                        binding.hilirRv.smoothScrollToPosition(binding.hilirRv.adapter!!.itemCount - 1)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("Data", error.getMessage()) //Don't ignore errors!
            }

        })
    }

    private fun getDataHilir2() {
        val database = Firebase.database
        val ref = database.getReference("sungai2")

        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    var tmpArrList = arrayListOf<HuluHilir>()

                    for (classSnapshot in snapshot.child("hilir").children) {
                        var distance = classSnapshot.child("hasil").getValue().toString()
                        var datetime = classSnapshot.child("timestamp").getValue().toString()

                        var hilir = HuluHilir(distance, datetime)

                        tmpArrList.add(hilir!!)
                    }

                    hilir2ArrayList.clear()
                    hilir2ArrayList.addAll(tmpArrList)
                    tmpArrList.clear()

                    adapterHilir2.notifyDataSetChanged()

                    if (binding.hilir2Rv.adapter!!.itemCount > 0) {
                        binding.hilir2Rv.smoothScrollToPosition(binding.hilir2Rv.adapter!!.itemCount - 1)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("Data", error.getMessage()) //Don't ignore errors!
            }

        })
    }

    private fun getDataSuhu() {
        val database = Firebase.database
        val ref = database.getReference("sungai1")

        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    var tmpArrList = arrayListOf<Suhu>()

                    for (classSnapshot in snapshot.child("suhu").children) {
                        var celcius = classSnapshot.child("hasil").getValue().toString()
                        var datetime = classSnapshot.child("timestamp").getValue().toString()

                        var suhu = Suhu(celcius, datetime)

                        tmpArrList.add(suhu!!)
                    }

                    suhuArrayList.clear()
                    suhuArrayList.addAll(tmpArrList)
                    tmpArrList.clear()

                    adapterSuhu.notifyDataSetChanged()

                    if (binding.suhuRv.adapter!!.itemCount > 0) {
                        binding.suhuRv.smoothScrollToPosition(binding.suhuRv.adapter!!.itemCount - 1)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("Data", error.getMessage()) //Don't ignore errors!
            }

        })
    }

    private fun getDataSuhu2() {
        val database = Firebase.database
        val ref = database.getReference("sungai2")

        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    var tmpArrList = arrayListOf<Suhu>()

                    for (classSnapshot in snapshot.child("suhu").children) {
                        var celcius = classSnapshot.child("hasil").getValue().toString()
                        var datetime = classSnapshot.child("timestamp").getValue().toString()

                        var suhu = Suhu(celcius, datetime)

                        tmpArrList.add(suhu!!)
                    }

                    suhu2ArrayList.clear()
                    suhu2ArrayList.addAll(tmpArrList)
                    tmpArrList.clear()

                    adapterSuhu2.notifyDataSetChanged()

                    if (binding.suhu2Rv.adapter!!.itemCount > 0) {
                        binding.suhu2Rv.smoothScrollToPosition(binding.suhu2Rv.adapter!!.itemCount - 1)
                    }
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

        //Hulu2
        adapterHulu2 = Adapter(hulu2ArrayList)

        manager12 = LinearLayoutManager(this)
        manager12.reverseLayout = true
        manager12.stackFromEnd = true

        binding.hulu2Rv.layoutManager = manager12
        binding.hulu2Rv.adapter = adapterHulu2

        //Hilir2
        adapterHilir2 = Adapter(hilir2ArrayList)

        manager22 = LinearLayoutManager(this)
        manager22.reverseLayout = true
        manager22.stackFromEnd = true

        binding.hilir2Rv.layoutManager = manager22
        binding.hilir2Rv.adapter = adapterHilir2

        //Suhu2
        adapterSuhu2 = SuhuAdapter(suhu2ArrayList)

        manager32 = LinearLayoutManager(this)
        manager32.reverseLayout = true
        manager32.stackFromEnd = true

        binding.suhu2Rv.layoutManager = manager32
        binding.suhu2Rv.adapter = adapterSuhu2
        
        Log.d("Adapter", "Set Adapter Successful")

    }
}