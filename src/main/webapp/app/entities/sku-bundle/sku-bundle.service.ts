import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { ISkuBundle } from 'app/shared/model/sku-bundle.model';

type EntityResponseType = HttpResponse<ISkuBundle>;
type EntityArrayResponseType = HttpResponse<ISkuBundle[]>;

@Injectable({ providedIn: 'root' })
export class SkuBundleService {
    public resourceUrl = SERVER_API_URL + 'api/sku-bundles';

    constructor(protected http: HttpClient) {}

    create(skuBundle: ISkuBundle): Observable<EntityResponseType> {
        return this.http.post<ISkuBundle>(this.resourceUrl, skuBundle, { observe: 'response' });
    }

    update(skuBundle: ISkuBundle): Observable<EntityResponseType> {
        return this.http.put<ISkuBundle>(this.resourceUrl, skuBundle, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<ISkuBundle>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<ISkuBundle[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
