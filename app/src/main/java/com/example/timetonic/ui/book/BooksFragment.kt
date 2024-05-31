package com.example.timetonic.ui.book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.timetonic.databinding.FragmentBooksBinding
import com.example.timetonic.ui.book.BooksFragmentArgs
import com.example.timetonic.ui.book.adapter.BookAdapter

class BooksFragment : Fragment() {

    private val viewModel: BookViewModel by viewModels()
    private lateinit var binding: FragmentBooksBinding
    private val args: BooksFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBooksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sesskey = args.sesskey

        binding.booksRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.books.observe(viewLifecycleOwner) { books ->
            binding.booksRecyclerView.adapter = BookAdapter(books)
        }

        viewModel.fetchBooks(sesskey)
    }
}