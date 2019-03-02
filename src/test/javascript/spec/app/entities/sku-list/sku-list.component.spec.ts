/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { BuyTogetherTestModule } from '../../../test.module';
import { SkuListComponent } from 'app/entities/sku-list/sku-list.component';
import { SkuListService } from 'app/entities/sku-list/sku-list.service';
import { SkuList } from 'app/shared/model/sku-list.model';

describe('Component Tests', () => {
    describe('SkuList Management Component', () => {
        let comp: SkuListComponent;
        let fixture: ComponentFixture<SkuListComponent>;
        let service: SkuListService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [BuyTogetherTestModule],
                declarations: [SkuListComponent],
                providers: []
            })
                .overrideTemplate(SkuListComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(SkuListComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(SkuListService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new SkuList(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.skuLists[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
