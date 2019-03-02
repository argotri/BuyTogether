/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { BuyTogetherTestModule } from '../../../test.module';
import { SkuListDetailComponent } from 'app/entities/sku-list/sku-list-detail.component';
import { SkuList } from 'app/shared/model/sku-list.model';

describe('Component Tests', () => {
    describe('SkuList Management Detail Component', () => {
        let comp: SkuListDetailComponent;
        let fixture: ComponentFixture<SkuListDetailComponent>;
        const route = ({ data: of({ skuList: new SkuList(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [BuyTogetherTestModule],
                declarations: [SkuListDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(SkuListDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(SkuListDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.skuList).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
