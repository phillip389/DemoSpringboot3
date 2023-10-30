import { Component, OnInit } from '@angular/core';

import { Observable, Subject } from 'rxjs';

import {
   debounceTime, distinctUntilChanged, switchMap
 } from 'rxjs/operators';

import { Hero } from '../hero';
import { HeroService } from '../hero.service';

@Component({
  selector: 'app-hero-search',
  templateUrl: './hero-search.component.html',
  styleUrls: [ './hero-search.component.css' ]
})
export class HeroSearchComponent implements OnInit {
  heroes$!: Observable<Hero[]>;
  private searchTerms = new Subject<Hero>();

  heroSearch: Hero = { id: 0, name: '', power: ''};

  constructor(private heroService: HeroService) {}

  // Push a search term into the observable stream.
  searchName(term: string): void {
    this.heroSearch.name = term;
    this.searchTerms.next(this.heroSearch);
  }

  // Push a search term into the observable stream.
  searchPower(term: string): void {
    this.heroSearch.power = term;
    this.searchTerms.next(this.heroSearch);
  }

  ngOnInit(): void {
    this.heroes$ = this.searchTerms.pipe(
      // wait 300ms after each keystroke before considering the term
      debounceTime(300),

      // ignore new term if same as previous term
      distinctUntilChanged(),

      // switch to new search observable each time the term changes
      switchMap((term: Hero) => this.heroService.searchHeroes(term)),
    );
  }
}
