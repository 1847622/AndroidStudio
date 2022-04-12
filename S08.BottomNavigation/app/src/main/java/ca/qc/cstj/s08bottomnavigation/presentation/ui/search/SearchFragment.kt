package ca.qc.cstj.s08bottomnavigation.presentation.ui.search

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.icu.number.NumberFormatter.with
import android.os.Build
import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ca.qc.cstj.s08bottomnavigation.R
import ca.qc.cstj.s08bottomnavigation.core.Constants
import ca.qc.cstj.s08bottomnavigation.core.LoadingResource
import ca.qc.cstj.s08bottomnavigation.core.text
import ca.qc.cstj.s08bottomnavigation.databinding.FragmentSearchBinding
import ca.qc.cstj.s08bottomnavigation.domain.models.Meteo
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.withContext
import java.time.Instant
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.Locale.filter


class SearchFragment : Fragment(R.layout.fragment_search) {

    private val binding: FragmentSearchBinding by viewBinding()
    private val viewModel: SearchViewModel by viewModels()

    private lateinit var ctlMainActivity : ConstraintLayout

    // Dans l'activité la majorité du code est dans onCreate()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ctlMainActivity = requireActivity().findViewById(R.id.ctlMainActivity)

        viewModel.meteo.observe(viewLifecycleOwner) {
            when (it) {
                is LoadingResource.Error -> {
                    binding.pgbLoading.hide()
                    binding.grpMeteo.visibility = View.INVISIBLE
                    binding.txvNotAvailable.visibility = View.VISIBLE
                    Snackbar.make(
                        binding.root,
                        it.throwable.localizedMessage!!,
                        Snackbar.LENGTH_LONG
                    ).show()
                }
                is LoadingResource.Loading -> {
                    binding.pgbLoading.show()
                    binding.grpMeteo.visibility = View.INVISIBLE
                    binding.txvNotAvailable.visibility = View.INVISIBLE
                }
                is LoadingResource.Success -> {
                    binding.pgbLoading.hide()
                    binding.grpMeteo.visibility = View.VISIBLE
                    binding.txvNotAvailable.visibility = View.INVISIBLE
                    showMeteo(it.data!!)
                }
            }
        }

        binding.btnSearch.setOnClickListener {
            viewModel.search(binding.tilSearch.text)
        }


    }

    private fun showMeteo(meteo: Meteo) {
        binding.txvCity.text = meteo.city
        binding.txvTemperature.text = getString(R.string.temperatureFormat,meteo.temperature) // TODO
        binding.txvSky.text = meteo.weather

        Glide.with(binding.root.context)
            .load(Constants.LOAD_FLAG_API.format(meteo.flag).lowercase())
            .into(binding.imvCountry)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val formatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                .withZone(ZoneId.systemDefault())

            binding.txvDateAPI.text = formatter.format(Instant.ofEpochSecond(meteo.timestamp.toLong())
                .atZone(ZoneOffset.UTC).plusSeconds(meteo.timeZone.toLong()))
            binding.txvDatePhone.text = formatter.format(Instant.now().atZone(ZoneId.systemDefault()))

        }
        val background = if (meteo.temperature >= Constants.TEMPERATURE_BREAKPOINT){
             ContextCompat.getDrawable(requireContext(),R.drawable.warm)
        }else{
             ContextCompat.getDrawable(requireContext(),R.drawable.cold)
        }
        background!!.colorFilter = PorterDuffColorFilter(ContextCompat.getColor(requireContext(),R.color.filter),PorterDuff.Mode.DARKEN)

        ctlMainActivity.background = background
    }



}