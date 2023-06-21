package com.example.massivechallage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.massivechallage.data.adapter.AdapterKontakPolisi
import com.example.massivechallage.data.KontakPolisi
import com.google.firebase.database.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [KontakLaporanFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class KontakLaporanFragment : Fragment() {

    private lateinit var dbref: DatabaseReference
    private lateinit var kprecyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_kontak_laporan, container, false)
        kprecyclerView = view.findViewById(R.id.listkontakpolisi)
        return view
    }
    override fun onCreate( savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        kprecyclerView.layoutManager = LinearLayoutManager(requireContext())
        var kpArrayList = ArrayList<KontakPolisi>()
        val adapter = AdapterKontakPolisi(kpArrayList)
        kprecyclerView.adapter = adapter
        getKpData(adapter)
    }
    private fun getKpData(adapter : AdapterKontakPolisi) {
        dbref = FirebaseDatabase.getInstance().getReference("polsek")

        dbref.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                   val kpArrayList = ArrayList<KontakPolisi>()
                    for (kpSnapshot in snapshot.children) {

                        val kp = kpSnapshot.getValue(KontakPolisi::class.java)
                        kp?.let {
                            kpArrayList.add(it)
                        }

                    }

                    Toast.makeText(requireContext(),"Test Data $kpArrayList", Toast.LENGTH_SHORT).show()
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(requireContext(),"Test Data $error", Toast.LENGTH_SHORT).show()
            }

        })
    }


}