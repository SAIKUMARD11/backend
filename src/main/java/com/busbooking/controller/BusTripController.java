package com.busbooking.controller;
import com.busbooking.model.BusTrip;import com.busbooking.repository.BusTripRepository;import org.springframework.web.bind.annotation.*;import java.time.LocalDate;import java.util.List;import java.util.stream.Collectors;
@RestController @RequestMapping("/api/trips") public class BusTripController {
 private final BusTripRepository repo; public BusTripController(BusTripRepository r){repo=r;}
 @GetMapping public List<BusTrip> all(@RequestParam(required=false) String from,@RequestParam(required=false) String to,@RequestParam(required=false) String date){
 if(from!=null&&!from.isBlank()&&to!=null&&!to.isBlank()&&date!=null&&!date.isBlank())return repo.findBySourceCityIgnoreCaseAndDestinationCityIgnoreCaseAndTravelDate(from.trim(),to.trim(),LocalDate.parse(date));
 return repo.findAll().stream().filter(t->from==null||from.isBlank()||t.getSourceCity().toLowerCase().contains(from.toLowerCase())).filter(t->to==null||to.isBlank()||t.getDestinationCity().toLowerCase().contains(to.toLowerCase())).collect(Collectors.toList());}
 @GetMapping("/{id}") public BusTrip one(@PathVariable Long id){return repo.findById(id).orElseThrow(()->new RuntimeException("Trip not found"));}
}
