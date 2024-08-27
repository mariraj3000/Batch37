package com.tnsif.sm.CollegeService;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import java.util.List;
	import java.util.Optional;

	@Service
	public class CollegeService {

	    @Autowired
	    private CollegeRepository collegeRepository;

	    public List<College> findAll() {
	        return collegeRepository.findAll();
	    }

	    public Optional<College> findById(Long id) {
	        return collegeRepository.findById(id);
	    }

	    public College save(College college) {
	        return collegeRepository.save(college);
	    }

	    public void deleteById(Long id) {
	        collegeRepository.deleteById(id);
	    }
	}



