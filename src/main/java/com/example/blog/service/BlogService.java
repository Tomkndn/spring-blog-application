package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public Optional<Blog> getBlogById(Long id) {
        return blogRepository.findById(id);
    }

    public Blog updateBlog(Long id, Blog blogDetails) {
        return blogRepository.findById(id).map(blog -> {
            blog.setTitle(blogDetails.getTitle());
            blog.setContent(blogDetails.getContent());
            blog.setAuthor(blogDetails.getAuthor());
            return blogRepository.save(blog);
        }).orElseThrow(() -> new RuntimeException("Blog not found with id " + id));
    }

    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
}
