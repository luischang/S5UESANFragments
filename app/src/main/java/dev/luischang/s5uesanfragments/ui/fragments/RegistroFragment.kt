package dev.luischang.s5uesanfragments.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import dev.luischang.s5uesanfragments.R

class RegistroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_registro, container, false)

        val spnCountry: Spinner = view.findViewById(R.id.spnCountry)
        val etFullName: EditText = view.findViewById(R.id.etFullName)
        val etEmail: EditText = view.findViewById(R.id.etEmail)
        val rgGender: RadioGroup = view.findViewById(R.id.rgGender)
        //val chkLicense: CheckBox = view.findViewById(R.id.chkLicense)
        //val chkCar: CheckBox = view.findViewById(R.id.chkCar)

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.country_array,
            android.R.layout.simple_spinner_item
        ).also { adapter->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spnCountry.adapter = adapter
        }

        val btnSave: Button = view.findViewById(R.id.btnSave)
        var spnCountryValue=""

        spnCountry.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                spnCountryValue = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        btnSave.setOnClickListener {
            var fullNameValue = etFullName.text
            var emailValue = etEmail.text
            val intSelectButton = rgGender!!.checkedRadioButtonId
            val radioButton: RadioButton = view.findViewById(intSelectButton)
            val genderValue = radioButton.text

            Toast.makeText(requireContext(),"Full Name: $fullNameValue",Toast.LENGTH_LONG ).show()
            Toast.makeText(requireContext(),"Email: $emailValue",Toast.LENGTH_LONG ).show()
            Toast.makeText(requireContext(),"Gender: $genderValue",Toast.LENGTH_LONG ).show()
            Toast.makeText(requireContext(),"Country: $spnCountryValue",Toast.LENGTH_LONG ).show()

        }



        return view
    }

}