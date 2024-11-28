package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SongDetailsController {

    private final SongService songService;
    private final ArtistService artistService;

    @Autowired
    public SongDetailsController(SongService songService, ArtistService artistService) {
        this.songService = songService;
        this.artistService = artistService;
    }

    @GetMapping("/songDetails")
    public String showSongDetails(Model model) {
        Song s = songService.listSongs().stream().findFirst().orElse(null);
        model.addAttribute("selectedSong", s);
        return "songDetails"; // Thymeleaf will look for songDetails.html
    }

    @PostMapping("/songDetails")
    public String addArtistToSong(@RequestParam("trackId") Long trackId,
                                  @RequestParam("artistId") String artistId,
                                  Model model) {
        Song s = songService.findByTrackId(trackId);
        if (s != null && artistId != null) {
            Artist a = artistService.findById(Long.valueOf(artistId)).orElse(null);
            if (a != null) {
                s.addArtist(a);
            }
        }
        model.addAttribute("selectedSong", s);
        return "songDetails"; // Thymeleaf will render songDetails.html again
    }
}
