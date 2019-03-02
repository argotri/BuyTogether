/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { BuyTogetherTestModule } from '../../../test.module';
import { SkuBundleComponent } from 'app/entities/sku-bundle/sku-bundle.component';
import { SkuBundleService } from 'app/entities/sku-bundle/sku-bundle.service';
import { SkuBundle } from 'app/shared/model/sku-bundle.model';

describe('Component Tests', () => {
    describe('SkuBundle Management Component', () => {
        let comp: SkuBundleComponent;
        let fixture: ComponentFixture<SkuBundleComponent>;
        let service: SkuBundleService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [BuyTogetherTestModule],
                declarations: [SkuBundleComponent],
                providers: []
            })
                .overrideTemplate(SkuBundleComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(SkuBundleComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(SkuBundleService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new SkuBundle(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.skuBundles[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
